package com.chenghui.ticket.pojo;

import javax.persistence.*;
import lombok.Data;

/**
 * @author Devil
 * @date 2020/3/16 1:36
 */
@Data
@Table(name = "message")
public class Message {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "message")
    private String message;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`type`")
    private Integer type;

    @Column(name = "add_name")
    private String addName;

    @Column(name = "createtime")
    private String createtime;
}