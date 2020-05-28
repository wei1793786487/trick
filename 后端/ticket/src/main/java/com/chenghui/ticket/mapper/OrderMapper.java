package com.chenghui.ticket.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.chenghui.ticket.pojo.Order;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Devil
 * @date 2020/3/14 17:20
 */
public interface OrderMapper extends Mapper<Order> {
    List<Order> selectAllBySearch(@Param("pid") Integer pid,@Param("tid") Integer tid);


   List<Order> selectByTid(@Param("tid")Integer tid);




}