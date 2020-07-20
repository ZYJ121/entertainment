package com.entertainment.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.HashMap;

/**
 * @Configuration 自动配置
 * @EnableCaching 启用缓存
 * @SpringBootApplication springboot启动类
 */
@Configuration
@EnableCaching
@EnableAsync
@SpringBootApplication
public class EntertainmentApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EntertainmentApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
