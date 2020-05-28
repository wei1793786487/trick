package com.chenghui.ticket.pojo;

import javax.persistence.*;
import lombok.Builder;
import lombok.Data;

/**
 * @author Devil
 * @date 2020/3/3 22:47
 */
@Data
@Table(name = "menu")
public class Menu {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "menu")
    private String menu;


}