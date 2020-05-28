package com.chenghui.ticket.handler;

import com.chenghui.ticket.utlis.JsonWriteUtlis;
import com.chenghui.ticket.utlis.annotation.ControllerLog;
import com.chenghui.ticket.utlis.exception.ValidateCodeException;
import com.chenghui.ticket.utlis.result.enums.ResultCode;
import com.chenghui.ticket.utlis.result.pojo.JsonResult;
import com.chenghui.ticket.utlis.result.utils.ResultTool;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Devil
 * @date 2020/1/5 20:38
 * 登录失败的逻辑处理器
 */
@Component
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @ControllerLog(describe = "登录异常")
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        JsonResult result = null;
        if (e instanceof AccountExpiredException) {
            //账号过期
            result = ResultTool.fail(ResultCode.USER_ACCOUNT_EXPIRED);
        } else if (e instanceof BadCredentialsException) {
            //密码错误
            result = ResultTool.fail(ResultCode.USER_CREDENTIALS_ERROR);
        } else if (e instanceof CredentialsExpiredException) {
            //密码过期
            result = ResultTool.fail(ResultCode.USER_CREDENTIALS_EXPIRED);
        } else if (e instanceof DisabledException) {
            //账号不可用
            result = ResultTool.fail(ResultCode.USER_ACCOUNT_DISABLE);
        } else if (e instanceof LockedException) {
            //账号锁定
            result = ResultTool.fail(ResultCode.USER_ACCOUNT_LOCKED);
        } else if (e instanceof InternalAuthenticationServiceException) {
            //用户不存在
            result = ResultTool.fail(ResultCode.USER_ACCOUNT_NOT_EXIST);
        } else if (e instanceof ValidateCodeException){
            JsonResult jsonResult=new JsonResult();
            jsonResult.setCode(400);
            jsonResult.setErrorMsg(e.getMessage());
            jsonResult.setSuccess(false);
            result=jsonResult;
        }else {
            //其他错误
            result = ResultTool.fail(ResultCode.COMMON_FAIL);
        }
        JsonWriteUtlis.fail(request,response, result);

    }
}

