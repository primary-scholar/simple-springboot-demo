package com.mimu.springboot.mybatis.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * author: mimu
 * date: 2019/10/30
 */
@Configuration
@Import(value = {SchoolDataSourceConfig.class, StudentDataSourceConfig.class})
public class ApplicationConfig {
}
