package com.mimu.springboot.debug.conditions.config.condition;

import com.mimu.springboot.debug.conditions.condition.SimpleConditionA;
import com.mimu.springboot.debug.conditions.condition.SimpleConditionB;
import com.mimu.springboot.debug.conditions.condition.SimpleRegistBeanPhaseCondition;
import com.mimu.springboot.debug.conditions.depen.ConditionDependencyBean;
import com.mimu.springboot.debug.conditions.model.ConditionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * author: mimu
 * date: 2019/7/26
 */

/**
 * 如果 @ComponentScan 中 basePackages 的目录不正确 则不会生成 conditionB 的 实例
 * 因为 conditionB() 方法上使用了 @ConditionOnBean 的注解
 * 对于 具有参数的 方法 conditionB(ConditionDependencyBean conditionDependencyBean) 会使用 自动注入的方式从
 * DefaultListableBeanFactory 中获取参数实例，然后反射调用该方法生成 对象
 */
@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackages = {"com.mimu.springboot.debug.conditions.model"})
public class SimpleConditionRegisterBeanPhaseConfig {
    private static Logger logger = LoggerFactory.getLogger(SimpleConditionRegisterBeanPhaseConfig.class);

    /**
     * 嵌套的config class 跟外层的 @configuration 标注的类解析是一样的 是在 processMemberClasses
     * 中进行处理的
     */
    @Configuration
    static class SimpleConditionAConfig {
        @Bean
        @Conditional(SimpleConditionA.class)
        public ConditionBean conditionA() {
            return new ConditionBean("condition a");
        }

    }

    @Bean
    @Conditional(SimpleConditionB.class)
    @ConditionalOnBean(ConditionDependencyBean.class)
    public ConditionBean conditionB(ConditionDependencyBean conditionDependencyBean, ConditionDependencyBean conditionDependencyBean1) {
        logger.info("conditionB={}", conditionDependencyBean);
        return new ConditionBean("condition b");
    }

    /**
     * @return
     * @conditional 注解中包含多个 condition 实现类时取 && 操作
     */
    @Bean
    @Conditional({SimpleConditionA.class, SimpleConditionB.class})
    public ConditionBean conditionAB() {
        return new ConditionBean("condition a and b");
    }

    @Bean
    @Conditional(SimpleRegistBeanPhaseCondition.class)
    public ConditionBean conditionRegisterBeanPhaseBean() {
        return new ConditionBean("simple register bean phase conditionRegisterBeanPhaseBean");
    }
}
