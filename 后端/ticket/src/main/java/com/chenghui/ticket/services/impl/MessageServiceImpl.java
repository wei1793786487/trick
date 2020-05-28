package com.chenghui.ticket.services.impl;

import cn.hutool.core.date.DateUtil;
import com.chenghui.ticket.pojo.LayUi;
import com.chenghui.ticket.utlis.exception.ExceptionEnums;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.chenghui.ticket.pojo.Message;
import com.chenghui.ticket.pojo.SysUser;
import com.chenghui.ticket.services.UserService;
import com.chenghui.ticket.utlis.exception.XxException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.chenghui.ticket.mapper.MessageMapper;
import com.chenghui.ticket.services.MessageService;

import java.util.List;

/**
 * @author Devil
 * @date 2020/3/12 17:38
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private UserService sysUserService;

    @Override
    public LayUi select(String search, Integer page, Integer limit, Integer type) {
        PageHelper.startPage(page, limit);
        List<Message> messages = messageMapper.selectAllBySearch(search, type);
        if (messages == null || messages.size() == 0) {
            throw new XxException(ExceptionEnums.NOT_FIND);
        }
        PageInfo<Message> brandPageInfo = new PageInfo<>();
        LayUi<Message> layUi = new LayUi<>();
        layUi.setCount(brandPageInfo.getTotal());
        layUi.setData(messages);
        return layUi;
    }

    @Override
    public void chance(Message message) {

        int update = messageMapper.updateByPrimaryKeySelective(message);
        if (update != 1) {
            throw new XxException(ExceptionEnums.UPDATE_ERROR);
        }
    }

    @Override
    public void delectmessage(Integer[] ids) {
        for (Integer id : ids) {
            log.info("删除id为" + id + "的消息");
            messageMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void insertmessage(Message message) {
        SysUser userByUserName = sysUserService.findUserByUserName(null);
        if (userByUserName==null){
            throw new XxException(ExceptionEnums.USER_NOT_lOGIN);
        }
        if (message.getAddName() == null) {
            message.setAddName(userByUserName.getUsername());
        }
        String now = DateUtil.now();
        message.setCreatetime(now);
        if (message.getType()==0){
            message.setName("留言没有题目");
        }
        int insert = messageMapper.insert(message);
        if (insert != 1) {
            throw new XxException(ExceptionEnums.INSERT_ERROR);
        }
    }

    @Override
    public Message findOneById(Integer id) {
        Message message = messageMapper.selectByPrimaryKey(id);
        if (message == null) {
            throw new XxException(ExceptionEnums.NOT_FIND);
        }
        return message;
    }

    @Override
    public List<Message> selectnew(Integer limit) {
   return   messageMapper.selectnew(limit);
    }
}



