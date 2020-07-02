package com.mimu.springboot.dubbo.provider;

import com.mimu.springboot.dubbo.provider.config.DataSourceConfig;
import com.mimu.springboot.dubbo.provider.config.ServiceProviderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * author: mimu
 * date: 2019/8/18
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class})
@Import(value = {DataSourceConfig.class, ServiceProviderConfig.class})
public class DubboProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class);
    }
}
