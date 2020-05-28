package com.chenghui.ticket.mapper;

import com.chenghui.ticket.pojo.Back;
import org.apache.ibatis.annotations.Param;import tk.mybatis.mapper.common.Mapper;import java.util.List;

/**
 * @author Devil
 * @date 2020/5/28 12:30
 */
public interface BackMapper extends Mapper<Back> {
    List<Back> selectBySearch(@Param("search") String search);
}