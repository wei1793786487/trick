package com.chenghui.ticket.utlis.result.pojo;

import com.chenghui.ticket.utlis.result.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Devil
 * @date 2020/1/5 15:25
 * 用来返回统一的实体类
 */
@Data
public class JsonResult<T> implements Serializable {
    private Boolean success;
    private Integer Code;
    private String errorMsg;
    private T data;


    public JsonResult() {
    }

    public JsonResult(boolean success) {
        this.success = success;
        this.Code = success ? ResultCode.SUCCESS.getCode() : ResultCode.COMMON_FAIL.getCode();
        this.errorMsg = success ? ResultCode.SUCCESS.getMessage() : ResultCode.COMMON_FAIL.getMessage();
    }

    public JsonResult(boolean success, ResultCode resultEnum) {
        this.success = success;
        this.Code = success ? ResultCode.SUCCESS.getCode() : (resultEnum == null ? ResultCode.COMMON_FAIL.getCode() : resultEnum.getCode());
        this.errorMsg = success ? ResultCode.SUCCESS.getMessage() : (resultEnum == null ? ResultCode.COMMON_FAIL.getMessage() : resultEnum.getMessage());
    }

    public JsonResult(boolean success, T data) {
        this.success = success;
        this.Code = success ? ResultCode.SUCCESS.getCode() : ResultCode.COMMON_FAIL.getCode();
        this.errorMsg = success ? ResultCode.SUCCESS.getMessage() : ResultCode.COMMON_FAIL.getMessage();
        this.data = data;
    }

    public JsonResult(boolean success, ResultCode resultEnum, T data) {
        this.success = success;
        this.Code = success ? ResultCode.SUCCESS.getCode() : (resultEnum == null ? ResultCode.COMMON_FAIL.getCode() : resultEnum.getCode());
        this.errorMsg = success ? ResultCode.SUCCESS.getMessage() : (resultEnum == null ? ResultCode.COMMON_FAIL.getMessage() : resultEnum.getMessage());
        this.data = data;
    }



}
