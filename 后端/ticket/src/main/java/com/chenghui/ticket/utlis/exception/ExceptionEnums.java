package com.chenghui.ticket.utlis.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Devil
 * @date 2019/12/18 21:03
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter

public enum ExceptionEnums {
    /**
     * 错误类
     */
    ADD_ERROR(400, "添加异常"),
    TICKET_NOT_FIND(400, "车辆未找到"),
    USER_NOT_FIND(404, "用户没有找到"),
    TICKE_NOT_FIND(404, "票已售完"),
    TICKE_IS_HAVE(404, "此票你已经购买过"),
    ORDER_UPDATA_ERROR(400,"只允许修改相同目的地与出发地"),
    USER_PASSWORD_ERROR(400, "密码输入错误"),
    REGIST_ERROR(500, "注册异常"),
    NOT_FIND(400,"未找到该信息"),
    DELETE_ERROR(500, "删除异常"),
    INSERT_ERROR(500, "插入异常"),
    USER_ISHAVE(400, "用户已经存在"),
    ADDRESS_ERROR(500, "地点检索失败"),
    RESOUT_NOT_ONE(500, "结果集不唯一"),
    ROLE_NOT_FIND(400, "角色信息没找到"),
    PHONE_RRROR(400, "联系方式格式不正确"),
    INSUFFICIENT_AUTHORITY(403, "权限不足"),
    PERSON_EXIST(401, "该姓名人员已经存在"),
    LOG_NOT_FIND(404, "日志未找到"),
    PARAMETER_ERROT(400, "参数错误"),
    LOFIN_ERROR(400, "账号或者密码错误"),
    EMPTY_ERROR(400, "输入项为空"),
    PASSWORD_ERROR(400, "密码必须包含字母与数字，且在6到18位之间"),
    UPDATE_ERROR(500, "更新异常"),
    SERVER_ERROR(500, "服务器异常"),
    FIlE_IS_NULL(400, "文件为空"),
    SELECT_ERROR(400, "查询异常"),
    USER_NOT_lOGIN(403, "用户未登录"),
    UPDATEPASSWORD_ERROR(400, "密码错误"),
    UPDATEUSER_ERROR(400, "更新用户出现错误"),
    MENU_NOT_FIND(404, "菜单没找到"),
    USER_NOT_USE(403, "用户不可用");
    private int code;
    private String Msg;
}
