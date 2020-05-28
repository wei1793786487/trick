package com.chenghui.ticket.pojo;

import javax.persistence.*;
import lombok.Data;

/**
 * @author Devil
 * @date 2020/5/28 12:30
 */
@Data
@Table(name = "back")
public class Back {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "trickname")
    private String trickname;

    @Column(name = "back_money")
    private String backMoney;

    @Column(name = "to_address")
    private String toAddress;

    @Column(name = "start_address")
    private String startAddress;

    @Column(name = "oper_time")
    private String operTime;
}