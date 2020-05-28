package com.chenghui.ticket.handler;

import com.chenghui.ticket.utlis.CookieUtils;
import com.chenghui.ticket.utlis.exception.ValidateCodeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Devil
 * @date 2020/1/8 18:31
 * 验证码校验filter
 */
@Controller
public class CustomizeValidateCodeFilter extends OncePerRequestFilter {


    private AuthenticationFailureHandler authenticationFailureHandler;

    private StringRedisTemplate redisTemplate;

    /**
     * 因为过滤器是最后至执行的 所有没有办法注入 只能通过构造函数
     *
     * @param redisTemplate                redis处理
     * @param authenticationFailureHandler 验证码校验失败处理器
     */
    public CustomizeValidateCodeFilter(StringRedisTemplate redisTemplate, AuthenticationFailureHandler authenticationFailureHandler) {
        this.redisTemplate = redisTemplate;
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    private String cookie = null;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // authentication/form是认证时的请求接口，验证码校验只需要匹配这个接口即可

        if (StringUtils.equals("/login", httpServletRequest.getRequestURI()) &&
                StringUtils.equalsAnyIgnoreCase(httpServletRequest.getMethod(), "post")) {
            try {
                cookie = CookieUtils.getCookieValue(httpServletRequest, "getverid");
                validate(new ServletWebRequest(httpServletRequest));
            } catch (ValidateCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
                return;
            }
        }
        if (cookie!=null&&StringUtils.equals(cookie,"")){
            Boolean isDelete = redisTemplate.delete(cookie);
            String msg=isDelete ? "成功":"失败";
            logger.info( "删除redis的cookie"+msg+cookie );
            CookieUtils.deleteCookie(httpServletRequest,httpServletResponse,"getverid");
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }

    private void validate(ServletWebRequest request) throws ValidateCodeException {
        String getver = null;
        Map<String, String[]> parameterMap = request.getParameterMap();
        String captcha = request.getParameter("captcha");
        if (cookie != null) {
            getver = redisTemplate.opsForValue().get(cookie);
        }
        if (captcha == null) {
            throw new ValidateCodeException("请输入验证码");

        } else if (cookie == null) {
            throw new ValidateCodeException("验证码信息异常");

        } else if (getver == null) {
            throw new ValidateCodeException("验证码失效");

        } else if (!StringUtils.equalsIgnoreCase(getver, captcha)) {

            throw new ValidateCodeException("验证码不正确");
        }

    }
}
