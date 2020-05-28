package com.chenghui.ticket.services.impl;

import com.chenghui.ticket.pojo.LayUi;
import com.chenghui.ticket.utlis.exception.ExceptionEnums;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.chenghui.ticket.mapper.SysUserMapper;
import com.chenghui.ticket.pojo.SysUser;
import com.chenghui.ticket.services.UserService;
import com.chenghui.ticket.utlis.exception.XxException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Devil
 * @date 2020/1/5 19:33
 */

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
@Primary
public class SysUserServiceImpl implements UserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private PasswordEncoder passwordEncode;


    /**
     * spring security的认证的方法
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)) {
            throw new RuntimeException("用户名不能为空");
        }
        SysUser sysUser = sysUserMapper.findOneByUsername(username);
        if (sysUser == null) {
            throw new RuntimeException("查找不到用户");
        }
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        /**
         * 储存用户的权限
         * 这里只是简单的权限的控制因此只有一个权限
         */
        grantedAuthorities.add(new SimpleGrantedAuthority(sysUser.getRole()));

        User user = new User(sysUser.getUsername(), sysUser.getPassword(), sysUser.getIsenabled().equals(0) ? true : false, true, true, true, grantedAuthorities);


        return user;
    }

    /**
     * 查询用户
     *
     * @param username
     * @return
     */
    @Override
    public SysUser findUserByUserName(String username) {
        if (StringUtils.isBlank(username) || "null".equals(username)) {
            //如果用户没有传 自动读取security容器里面的用户名
            try {
                User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                username = userDetails.getUsername();
            } catch (Exception e) {
                return null;
            }
        }
        SysUser user = sysUserMapper.findOneByUsername(username);
        if (user == null) {
            throw new XxException(ExceptionEnums.USER_NOT_FIND);
        }
        return user;
    }

    /**
     * 更新登录时间
     *
     * @param lasttime
     * @param username
     */
    @Override
    public void updateLastimeByUserName(String lasttime, String username) {
        log.info("更新登录时间");
        int isUpdte = sysUserMapper.updateLasttimeByUsername(lasttime, username);
        if (isUpdte != 1) {
            log.error("更新时间失败");
        }

    }

    /**
     * 更新登录地点
     *
     * @param address
     * @param username
     */
    @Override
    public void updateLastAddressByUserName(String address, String username) {
        log.info("更新登录地点");
        int isUpdate = sysUserMapper.updateAddressByUsername(address, username);
        if (isUpdate != 1) {
            log.error("更新地点失败");
        }
    }

    /**
     * 更新密码
     *
     * @param oldPassword
     * @param newPassword
     * @param userName
     */
    @Override
    public void updateUserPasswordByUserName(String oldPassword, String newPassword, String userName) {
        log.info("更新用户密码");
        String rgx = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z\\\\W]{6,18}$";
        boolean matches = Pattern.matches(rgx, newPassword);
        if (matches) {
            SysUser user = findUserByUserName(userName);
            boolean isRigth = passwordEncode.matches(oldPassword, user.getPassword());
            if (isRigth) {
                String encodepssword = passwordEncode.encode(newPassword);
                int isUpdate = sysUserMapper.updatePasswordByUsername(encodepssword, userName);
                if (isUpdate != 1) {
                    throw new XxException(ExceptionEnums.UPDATE_ERROR);
                }
            } else {
                throw new XxException(ExceptionEnums.UPDATEPASSWORD_ERROR);
            }
        } else {
            throw new XxException(ExceptionEnums.PASSWORD_ERROR);
        }


    }

    /**
     * 更新用户
     *
     * @param sysUser
     */
    @Override
    public void updateUser(@Valid SysUser sysUser) {
        if (sysUser == null) {
            throw new XxException(ExceptionEnums.USER_NOT_FIND);
        }
        int isupdate = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if (isupdate != 1) {
            throw new XxException(ExceptionEnums.UPDATEUSER_ERROR);
        }
    }

    /**
     * 插入用户
     *
     * @param sysUser
     */
    @Override
    public void insertUser(SysUser sysUser) {
        sysUser.setPassword(passwordEncode.encode(sysUser.getPassword()));
        SysUser userByUserName = sysUserMapper.findOneByUsername(sysUser.getUsername());
        if (userByUserName != null) {
            throw new XxException(ExceptionEnums.USER_ISHAVE);
        }
        int insert = sysUserMapper.insertSelective(sysUser);

        if (insert != 1) {
            throw new XxException(ExceptionEnums.INSERT_ERROR);
        }
    }

    @Override
    public LayUi<SysUser> findUserList(Integer page, Integer limit, String search) {
        PageHelper.startPage(page, limit);
        List<SysUser> sysUsers = sysUserMapper.selectAllUser(search);

        if (sysUsers == null || sysUsers.size() == 0) {
            throw new XxException(ExceptionEnums.USER_NOT_FIND);
        }
        PageInfo<SysUser> brandPageInfo = new PageInfo<>(sysUsers);
        LayUi<SysUser> layUi = new LayUi<>();
        layUi.setCount(brandPageInfo.getTotal());
        layUi.setData(sysUsers);
        return layUi;
    }

    @Override
    public String findUsernameByUid(Integer id) {
        String username = sysUserMapper.selectUsernameById(id);
        if (username == null) {
            throw new XxException(ExceptionEnums.USER_NOT_FIND);
        }
        return username;
    }

    @Override
    public SysUser findOneById(Integer id) {
        SysUser oneById = sysUserMapper.findOneById(id);
        if (oneById == null) {
            throw new XxException(ExceptionEnums.USER_NOT_FIND);
        }
        return oneById;
    }

    @Override
    public void delectUser(Integer[] ids) {
        for (int id : ids) {
            int i = sysUserMapper.deleteByPrimaryKey(id);
            if (i!=1){
                throw new XxException(ExceptionEnums.DELETE_ERROR);
            }
        }

    }
}





