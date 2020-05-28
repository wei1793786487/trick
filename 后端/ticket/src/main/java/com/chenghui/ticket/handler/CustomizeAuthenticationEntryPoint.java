package com.chenghui.ticket.handler;

import com.chenghui.ticket.utlis.JsonWriteUtlis;
import com.chenghui.ticket.utlis.annotation.ControllerLog;
import com.chenghui.ticket.utlis.result.enums.ResultCode;
import com.chenghui.ticket.utlis.result.pojo.JsonResult;
import com.chenghui.ticket.utlis.result.utils.ResultTool;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Devil
 * @date 2020/1/5 20:38
 * 访问无权限用户
 */
@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @ControllerLog(describe = "访问非共享资源")
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        String message = e.getMessage();
        System.out.println(message);
        JsonResult result = ResultTool.fail(ResultCode.USER_NOT_LOGIN);
      JsonWriteUtlis.fail(httpServletRequest,httpServletResponse,result);
    }
}
