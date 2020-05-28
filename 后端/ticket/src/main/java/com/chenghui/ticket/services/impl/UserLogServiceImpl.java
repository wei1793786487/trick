package com.chenghui.ticket.services.impl;

import com.chenghui.ticket.pojo.LayUi;
import com.chenghui.ticket.pojo.SysUser;
import com.chenghui.ticket.pojo.UserLog;
import com.chenghui.ticket.services.UserLogService;
import com.chenghui.ticket.utlis.exception.ExceptionEnums;
import com.chenghui.ticket.utlis.exception.XxException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.chenghui.ticket.mapper.UserLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Devil
 * @date 2019/12/31 10:48
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class UserLogServiceImpl implements UserLogService {


    @Resource
    private UserLogMapper userLogMapper;

    @Resource
    private com.chenghui.ticket.services.UserService UserService ;


    /**
     * 查询所有日志
     *
     * @return
     */
    public List<UserLog> findAll() {
        List<UserLog> userLogs = userLogMapper.selectAll();
        if (userLogs == null || userLogs.size() == 0) {
            throw new XxException(ExceptionEnums.LOG_NOT_FIND);
        }
        return userLogs;
    }

    @Override
    public void insertLog(UserLog userLog) {
        userLogMapper.insertSelective(userLog);
    }

    @Override
    public LayUi selectLog(String serch, Integer page, Integer limit) {
        SysUser user =UserService.findUserByUserName(null);
        PageHelper.startPage(page, limit);
        List<UserLog> userLogs = userLogMapper.selectByAddId(user.getId(), serch);
        if (userLogs == null || userLogs.size() == 0) {
            log.error("日志未找到");
            throw new XxException(ExceptionEnums.LOG_NOT_FIND);
        }
        PageInfo<UserLog> brandPageInfo = new PageInfo<>(userLogs);
        LayUi<UserLog> layUi = new LayUi<>();
        layUi.setCount(brandPageInfo.getTotal());
        layUi.setData(userLogs);
        return layUi;
    }

    @Override
    
    public void deleteLog(Integer[] ids) {
        for (Integer id : ids) {
            log.info("删除id为" + id + "的会议");
            userLogMapper.deleteById(id);
        }
    }

    @Override
    public LayUi selectAllLog(String search, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<UserLog> userLogs = userLogMapper.selectAllLog(search);
        if (userLogs == null || userLogs.size() == 0) {
            log.error("日志未找到");
            throw new XxException(ExceptionEnums.LOG_NOT_FIND);
        }
        PageInfo<UserLog> brandPageInfo = new PageInfo<>(userLogs);
        LayUi<UserLog> layUi = new LayUi<>();
        layUi.setCount(brandPageInfo.getTotal());
        layUi.setData(userLogs);
        return layUi;
    }

}





