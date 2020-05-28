package com.chenghui.ticket.pojo;

import javax.persistence.*;
import lombok.Data;

/**
 * @author Devil
 * @date 2020/3/14 17:20
 */
@Data
@Table(name = "`order`")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`uid`")
    private Integer uid;

    @Column(name = "tid")
    private Integer tid;

    @Column(name = "pay")
    private Integer pay;

    @Column(name = "createtime")
    private String createtime;


    @Transient
    private String uname;

    @Transient
    private Ticketing ticketing;

    @Transient
    private String tname;
}