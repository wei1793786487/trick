package com.chenghui.ticket.services;

import com.chenghui.ticket.pojo.LayUi;

/**
 * @author Devil
 * @date 2020/5/28 11:16
 */
public interface BackService {

    LayUi select(String serch, Integer page, Integer limit);

    void delect(Integer[] ids);

}


