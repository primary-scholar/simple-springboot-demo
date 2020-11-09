package com.mimu.springboot.mybatis.generator.config;

import com.mimu.springboot.mybatis.generator.aspects.CustomDataSourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 author: mimu
 date: 2019/12/19
 */
@Configuration(proxyBeanMethods = false)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectConfig {

    @Bean
    public CustomDataSourceAspect customDataSourceAspect(){
        return new CustomDataSourceAspect();
    }
}
