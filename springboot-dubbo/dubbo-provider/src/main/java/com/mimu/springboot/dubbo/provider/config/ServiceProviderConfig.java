package com.mimu.springboot.dubbo.provider.config;

import com.mimu.springboot.dubbo.provider.service.dubbo.SchoolDataApiImpl;
import org.apache.dubbo.config.MetricsConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author: mimu
 * date: 2019/8/18
 */
@Configuration
//@ImportResource(locations = "classpath:dubbo.xml")
@EnableDubbo(scanBasePackageClasses = SchoolDataApiImpl.class)
public class ServiceProviderConfig {

    @Bean
    public MetricsConfig metricsConfig() {
        MetricsConfig config = new MetricsConfig();
        config.setProtocol("dubbo");
        config.setPort("20880");
        return config;
    }
}
