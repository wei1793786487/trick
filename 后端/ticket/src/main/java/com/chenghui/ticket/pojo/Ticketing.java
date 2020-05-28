package com.chenghui.ticket.pojo;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
*@author Devil
*@date  2020/3/12 17:39
*/
@Data
@Table(name = "ticketing")
public class Ticketing {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "train_name")
    private String trainName;

    @Column(name = "s_address")
    private String sAddress;

    @Column(name = "e_address")
    private String eAddress;

    @Column(name = "s_time")
    private String sTime;

    @Column(name = "e_time")
    private String eTime;

    @Column(name = "`number`")
    private Integer number;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "Price")
    private Double price;


}