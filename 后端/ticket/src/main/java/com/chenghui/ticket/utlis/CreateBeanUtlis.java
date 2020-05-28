package com.chenghui.ticket.utlis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;


/**
 * @author Devil
 * @data 2019/12/13 12:20
 **/

@Component
@Configuration
public class CreateBeanUtlis {


    @Resource
    private DataSource dataSource;


    /**
     * BCrypt加密
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        //数据源设置
        tokenRepository.setDataSource(dataSource);
        //启动的时候创建表，这里只执行一次，第二次就注释掉，否则每次启动都重新创建表
        //tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

}
