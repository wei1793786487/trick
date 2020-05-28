package com.chenghui.ticket.services;


import com.chenghui.ticket.pojo.Menu;

/**
 * @author Devil
 * @date 2020/1/5 16:28
 */
public interface MenuService {

    /**
     * 根据用户角色查找菜单
     *
     * @param username
     * @return
     */
    Menu findMenuByRolename(String username);


}




