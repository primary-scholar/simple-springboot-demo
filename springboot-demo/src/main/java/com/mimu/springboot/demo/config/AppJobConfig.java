package com.mimu.springboot.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration(proxyBeanMethods = false)
//@EnableScheduling // 开启 定时任务
public class AppJobConfig {
}
