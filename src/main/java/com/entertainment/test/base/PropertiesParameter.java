package com.entertainment.test.base;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 使用注解@ConfigurationProperties获取配置文件中的值
 * @Component把当前类作为bean交给spring管理
 * 获取配置文件中cross.name的值
 */

@Component
@ConfigurationProperties(prefix = "cross")
public class PropertiesParameter {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
