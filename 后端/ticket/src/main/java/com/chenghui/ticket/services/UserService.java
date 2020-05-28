package com.chenghui.ticket.services;

import com.chenghui.ticket.pojo.LayUi;
import com.chenghui.ticket.pojo.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Devil
 * @date 2020/1/5 19:33
 */
public interface UserService extends UserDetailsService {

    /**
     * 根据用户名查询用户
     *
     * @return
     */
    SysUser findUserByUserName(String username);

    /**
     * 根据用户名更新时间
     *
     * @param lasttime
     * @param username
     */
    void updateLastimeByUserName(String lasttime, String username);

    /**
     * 根据用户名更新时间
     *
     * @param address
     * @param username
     */
    void updateLastAddressByUserName(String address, String username);

    /**
     * 更新密码
     *
     * @param oldPassword
     * @param newPassword
     * @param userName
     */
    void updateUserPasswordByUserName(String oldPassword, String newPassword, String userName);


    /**
     * 更新用户
     *
     * @param sysUser
     */
    void updateUser(SysUser sysUser);


    /**
     * 新增用户
     *
     * @param sysUser
     */
    void insertUser(SysUser sysUser);

    /**
     * 查找所有用户
     */
    LayUi<SysUser> findUserList(Integer page, Integer limit, String search);

    /**
     * 根据id查询用户名
     */
    String findUsernameByUid(Integer id);

    /**
     * 根据id查询user
     * @param id
     * @return
     */
    SysUser findOneById(Integer id);

    /**
     * 删除用户
     */
    void delectUser(Integer[] ids);
}


