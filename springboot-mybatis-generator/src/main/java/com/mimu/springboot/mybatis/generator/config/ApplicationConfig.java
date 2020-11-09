package com.mimu.springboot.mybatis.generator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * author: mimu
 * date: 2019/10/30
 */
@Configuration(proxyBeanMethods = false)
@Import(value = {DataSourceConfig.class, MybatisConfig.class, AspectConfig.class})
public class ApplicationConfig {
}
