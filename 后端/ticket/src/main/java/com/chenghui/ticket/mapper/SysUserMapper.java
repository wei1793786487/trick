package com.chenghui.ticket.mapper;

import com.chenghui.ticket.pojo.SysUser;
import org.apache.ibatis.annotations.Param;import tk.mybatis.mapper.common.Mapper;import java.util.List;

/**
 * @author Devil
 * @date 2020/3/12 18:06
 */
public interface SysUserMapper extends Mapper<SysUser> {
    SysUser findOneByUsername(@Param("username") String username);

    int updateLasttimeByUsername(@Param("updatedLasttime") String updatedLasttime, @Param("username") String username);

    int updateAddressByUsername(@Param("updatedAddress") String updatedAddress, @Param("username") String username);

    int updatePasswordByUsername(@Param("updatedPassword") String updatedPassword, @Param("username") String username);

    List<SysUser> selectAllUser(@Param("search") String search);

    String selectUsernameById(@Param("id") Integer id);

    SysUser findOneById(@Param("id") Integer id);
}