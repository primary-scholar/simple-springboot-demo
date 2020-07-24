package com.mimu.springboot.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * author: mimu
 * date: 2019/10/9
 */
@Configuration
@Import({AppDataSourceConfig.class, AppServletConfig.class, AppRedisConfig.class, AppRestTemplateConfig.class, AppJobConfig.class})
public class ProjectApplicationConfig {
}
