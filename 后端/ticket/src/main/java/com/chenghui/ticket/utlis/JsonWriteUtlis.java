package com.chenghui.ticket.utlis;

import com.alibaba.fastjson.JSON;
import com.chenghui.ticket.utlis.result.pojo.JsonResult;
import com.chenghui.ticket.utlis.result.utils.ResultTool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Devil
 * @date 2020/1/5 20:11
 * 快速写出result的方法
 */
public class JsonWriteUtlis {
    /**
     * 请求成功的方法
     *
     * @param response
     * @throws IOException
     */
    public static void success(HttpServletResponse response) throws IOException {
        JsonResult result = ResultTool.success();
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }

    public static void fail(HttpServletRequest request, HttpServletResponse response, JsonResult result) throws IOException {
        if (result.getCode() > 2000 || result.getCode() < 2010) {
            CookieUtils.deleteCookie(request, response, "username");
        }
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }
}
