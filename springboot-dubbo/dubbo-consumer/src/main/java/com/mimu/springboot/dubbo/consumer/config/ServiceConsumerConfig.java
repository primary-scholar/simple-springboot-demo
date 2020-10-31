package com.mimu.springboot.dubbo.consumer.config;

import com.mimu.springboot.dubbo.consumer.service.CommonService;
import org.apache.dubbo.config.MetricsConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * author: mimu
 * date: 2019/8/18
 */
@Configuration
@ComponentScan(basePackageClasses = CommonService.class)
@EnableDubbo(scanBasePackageClasses = CommonService.class)
public class ServiceConsumerConfig {
/*    @Bean
    public MetricsConfig metricsConfig() {
        MetricsConfig config = new MetricsConfig();
        config.setProtocol("dubbo");
        config.setPort("20880");
        return config;
    }*/
}
