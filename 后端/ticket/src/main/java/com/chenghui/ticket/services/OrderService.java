package com.chenghui.ticket.services;

import com.chenghui.ticket.pojo.LayUi;
import com.chenghui.ticket.pojo.Order;

import java.util.List;

/**
 * @author Devil
 * @date 2020/3/14 16:49
 */
public interface OrderService {


    void addorder(Integer id);

    LayUi select(String serch, String pname, Integer page, Integer limit);

    void chance(Order order);

    double delect(Integer[] ids);

    List<Order> selectbytId(Integer id);

    void chanceorder(Integer id, Integer toid);
}

