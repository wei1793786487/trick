package com.chenghui.ticket.pojo;

import lombok.Data;

/**
 * @author Devil
 * @date 2020/1/9 1:33
 * 统一返回格式
 */
@Data
public class Common {


    private Integer code;

    private long timestamp;

    private Object data;

    public Common(Object data) {
        this.code = 200;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }
    public Common(Integer code, Object data) {
        this.code = code;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }
}
