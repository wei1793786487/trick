package com.chenghui.ticket.services;

import com.chenghui.ticket.pojo.LayUi;
import com.chenghui.ticket.pojo.Message;

import java.util.List;

/**
 * @author Devil
 * @date 2020/3/12 17:38
 */
public interface MessageService {


    LayUi select(String serch, Integer page, Integer limit, Integer type);

    void chance(Message message);

    void delectmessage(Integer[] ids);

    void insertmessage(Message message);

    Message findOneById(Integer id);

    List<Message> selectnew(Integer limit);
}



