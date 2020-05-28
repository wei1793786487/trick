package com.chenghui.ticket.pojo;

import javax.persistence.*;
import lombok.Data;

/**
 * @author Devil
 * @date 2020/3/12 18:06
 */
@Data
@Table(name = "sys_user")
public class SysUser {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "phone")
    private String phone;

    @Column(name = "`password`")
    private String password;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "address")
    private String address;

    @Column(name = "lasttime")
    private String lasttime;

    @Column(name = "`role`")
    private String role;

    @Column(name = "isEnabled")
    private Integer isenabled;
}