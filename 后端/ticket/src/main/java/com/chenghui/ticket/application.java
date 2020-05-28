package com.chenghui.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Devil
 * @date 2020/3/3 21:15
 */
@SpringBootApplication()
@MapperScan("com.chenghui.ticket.mapper")
public class application {
    public static void main(String[] args) {
        SpringApplication.run(application.class, args);
    }
}
