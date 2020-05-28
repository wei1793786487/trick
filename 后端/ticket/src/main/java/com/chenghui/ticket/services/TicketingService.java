package com.chenghui.ticket.services;

import com.chenghui.ticket.pojo.LayUi;
import com.chenghui.ticket.pojo.Ticketing;

import java.util.List;

/**
 * @author Devil
 * @date 2020/3/12 17:39
 */
public interface TicketingService {


    LayUi<Ticketing> findticketingServiceList(Integer page, Integer limit, String search);

    void delectticket(Integer[] ids);

    void insert(Ticketing ticketing);

    void chance(Ticketing ticketing);

    Ticketing findOneById(Integer id);

    List<Ticketing> findByEndAndStart(String saddress, String eaddress);

    Ticketing findOneByname(String name);
}
