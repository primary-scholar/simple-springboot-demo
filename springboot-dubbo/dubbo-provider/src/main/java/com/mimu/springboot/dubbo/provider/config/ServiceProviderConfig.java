package com.mimu.springboot.dubbo.provider.config;

import com.mimu.springboot.dubbo.provider.service.dubbo.SchoolDataApiImpl;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;

/**
 * author: mimu
 * date: 2019/8/18
 */
@Configuration
@EnableDubbo(scanBasePackageClasses = SchoolDataApiImpl.class)
public class ServiceProviderConfig {
}
