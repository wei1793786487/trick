package com.chenghui.ticket.services;


import com.chenghui.ticket.pojo.UserLog;
import com.chenghui.ticket.pojo.LayUi;

/**
 * @author Devil
 * @date 2019/12/31 10:48
 */
public interface UserLogService {

    /**
     * 日志保存
     */
    void insertLog(UserLog userLog);


    /**
     * @param serch
     * @param page
     * @param limit
     * @return
     */
    LayUi selectLog(String serch, Integer page, Integer limit);

    /**
     * @param ids
     */
    void deleteLog(Integer[] ids);

    /**
     * 超管查询日志
     *
     * @param serch
     * @param page
     * @param limit
     * @return
     */
    LayUi selectAllLog(String serch, Integer page, Integer limit);


}





