package com.chenghui.ticket.pojo;


import lombok.Data;

import java.util.List;

/**
 * @author Devil
 * @date 2019/12/31 23:10
 * layui的数据表格的统一的返回形式
 */
@Data
public class LayUi<T> {
    {
        this.code="0";
        this.msg="";
    }
    private String code;
    private String msg;
    private Long count;
    private List<T> data;
}
