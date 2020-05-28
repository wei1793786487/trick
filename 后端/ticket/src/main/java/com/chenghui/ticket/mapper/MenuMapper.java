package com.chenghui.ticket.mapper;

import com.chenghui.ticket.pojo.Menu;
import org.apache.ibatis.annotations.Param;import tk.mybatis.mapper.common.Mapper;

/**
 * @author Devil
 * @date 2020/3/3 22:47
 */
public interface MenuMapper extends Mapper<Menu> {
    Menu findOneByRoleName(@Param("roleName") String roleName);
}