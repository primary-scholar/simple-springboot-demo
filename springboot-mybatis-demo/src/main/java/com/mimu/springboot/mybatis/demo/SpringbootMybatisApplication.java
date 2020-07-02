package com.mimu.springboot.mybatis.demo;

import com.mimu.springboot.mybatis.demo.config.TermInfoDataSourceConfig;
import com.mimu.springboot.mybatis.demo.config.UserInfoDataSourceConfig;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class, MybatisAutoConfiguration.class})
@Import(value = {TermInfoDataSourceConfig.class, UserInfoDataSourceConfig.class})
public class SpringbootMybatisApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringbootMybatisApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run();
    }
}
