package com.chenghui.ticket.mapper;

import com.chenghui.ticket.pojo.Message;
import org.apache.ibatis.annotations.Param;import tk.mybatis.mapper.common.Mapper;import java.util.List;

/**
 * @author Devil
 * @date 2020/3/16 1:36
 */
public interface MessageMapper extends Mapper<Message> {
    List<Message> selectAllBySearch(@Param("search") String search, @Param("type") Integer type);

    String selectNamebyid(@Param("id") Integer id);
    List<Message> selectnew(Integer limit);


}