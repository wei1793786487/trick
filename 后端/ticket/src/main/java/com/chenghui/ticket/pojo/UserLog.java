package com.chenghui.ticket.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.*;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Devil
 * @date 2020/1/28 22:06
 */
@Data
@Table(name = "user_log")
public class UserLog implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "addid")
    private Integer addid;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`type`")
    private Integer type;

    @Column(name = "url")
    private String url;

    @Column(name = "requestType")
    private String requesttype;

    @Column(name = "requestParam")
    private String requestparam;

    @Column(name = "`user`")
    private String user;

    @Column(name = "ip")
    private String ip;


    @Column(name = "`time`")
    private Integer time;

    @Column(name = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;
    /**
     * 设置请求参数
     * @param paramMap
     */
    public void setMapToParams(Map<String, String[]> paramMap) {
        if (paramMap == null) {
            return;
        }
        Map<String, Object> params = new HashMap<>();


        for (Map.Entry<String, String[]> param : paramMap.entrySet()) {

            String key = param.getKey();
            String paramValue = (param.getValue() != null && param.getValue().length > 0 ? param.getValue()[0] : "");
            String obj = StringUtils.endsWithIgnoreCase(param.getKey(), "password") ? "密码不可见" : paramValue;
            params.put(key,obj);
        }
        this.requestparam = JSON.toJSONString(params);
    }
}