package com.chenghui.ticket.mapper;

import com.chenghui.ticket.pojo.Ticketing;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author Devil
 * @date 2020/3/12 17:39
 */
public interface TicketingMapper extends Mapper<Ticketing> {
    List<Ticketing> selectAllBySearch(@Param("search") String serch);

    Ticketing selectOneByTrainName(@Param("trainName") String trainName);

    String selectTrainNameById(@Param("id") Integer id);

    List<Ticketing> selectAllByse(@Param("saddress")String s,@Param("eaddress")String e);

    Ticketing findOneByTrainName(@Param("trainName")String trainName);



}