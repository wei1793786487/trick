package com.chenghui.ticket.config;

import com.chenghui.ticket.handler.*;
import com.chenghui.ticket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 成功的处理
     */
    @Autowired
    CustomizeAuthenticationSuccessHandler authenticationSuccessHandler;
    /**
     * 失败的处理器
     */
    @Autowired
    CustomizeAuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 登出成功的处理器
     */
    @Autowired
    private CustomizeLogoutSuccessHandler logoutSuccessHandler;

    /**
     * 匿名用户访问无权限资源时的异常
     */
    @Autowired
    CustomizeAuthenticationEntryPoint authenticationEntryPoint;

    /**
     * 权限拒绝处理逻辑
     */
    @Autowired
    CustomizeAccessDeniedHandler accessDeniedHandler;


    /**
     * 会话失效
     */
    @Autowired
    CustomizeSessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    /**
     * redis操作模板
     */
    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 验证码校验失败处理器
     */
    @Autowired
    private AuthenticationFailureHandler errorFailureHandler;


    @Autowired
    private PersistentTokenRepository persistentTokenRepository;


   @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 认证用户的来源
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 设置为数据库认证并指定是什么认证
         */
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    /**
     * 配置springsecuryy的相关信息
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.cors().and().csrf().disable();
        http.addFilterBefore(new CustomizeValidateCodeFilter(redisTemplate,errorFailureHandler), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/verifyCode.jpg").permitAll()
                .antMatchers("/message/allmessage").permitAll()
                .antMatchers("/user/adduser").permitAll()
                .antMatchers("/message/**").permitAll()

                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .permitAll()
                //成功的与失败的处理器
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and()
                .rememberMe()//记住我功能
                .userDetailsService(userService)
                .tokenRepository(persistentTokenRepository)
                .alwaysRemember(true)
                .authenticationSuccessHandler(authenticationSuccessHandler)
                .and().logout()
                .permitAll()
                //退出成功
                .logoutSuccessHandler(logoutSuccessHandler)
                .deleteCookies("JSESSIONID", "SESSION", "username")
                .and().exceptionHandling().
                //权限拒绝处理逻辑
                        accessDeniedHandler(accessDeniedHandler).
                //匿名用户访问无权限资源时的异常处理
                        authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement()
                .maximumSessions(1)
                //同一账号同时登录最大用户数
                .expiredSessionStrategy(sessionInformationExpiredStrategy);
    }
}
