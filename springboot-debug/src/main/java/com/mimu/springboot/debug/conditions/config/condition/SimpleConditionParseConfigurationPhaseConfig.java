package com.mimu.springboot.debug.conditions.config.condition;

import com.mimu.springboot.debug.conditions.condition.SimpleParseConfigPhaseCondition;
import com.mimu.springboot.debug.conditions.model.ConditionBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * author: mimu
 * date: 2020/5/18
 */
@Configuration(proxyBeanMethods = false)
@Conditional(SimpleParseConfigPhaseCondition.class)
@ComponentScan(basePackageClasses = ConditionBean.class)
public class SimpleConditionParseConfigurationPhaseConfig {

    @Bean
    public ConditionBean conditionParseConfigurationPhaseBean() {
        ConditionBean bean = new ConditionBean("conditionParseConfigurationPhaseBean");
        return bean;
    }
}
