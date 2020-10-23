package com.mimu.springboot.demo.config.customizer.hystrix;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisher;
import com.netflix.hystrix.strategy.properties.HystrixDynamicProperties;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * 支持 Hystrix 的跨线程的  log mdc 操作
 * 在 skyWalking 存在的情形下 依然支持
 */
@Configuration(proxyBeanMethods = false)
public class AppHystrixConcurrentStrategyConfig {

    @Configuration(proxyBeanMethods = false)
    public static class DefaultHystrixConcurrentStrategyReplace {
        @PostConstruct
        public void hystrixConcurrentStrategyInit() {
            HystrixConcurrencyStrategy concurrencyStrategy = HystrixPlugins.getInstance().getConcurrencyStrategy();
            HystrixCommandExecutionHook commandExecutionHook = HystrixPlugins.getInstance().getCommandExecutionHook();
            HystrixDynamicProperties dynamicProperties = HystrixPlugins.getInstance().getDynamicProperties();
            HystrixEventNotifier eventNotifier = HystrixPlugins.getInstance().getEventNotifier();
            HystrixMetricsPublisher metricsPublisher = HystrixPlugins.getInstance().getMetricsPublisher();
            HystrixPropertiesStrategy propertiesStrategy = HystrixPlugins.getInstance().getPropertiesStrategy();
            HystrixPlugins.reset();
            HystrixPlugins.getInstance().registerConcurrencyStrategy(new CustomHystrixConcurrentStrategy(concurrencyStrategy));
            HystrixPlugins.getInstance().registerCommandExecutionHook(commandExecutionHook);
            HystrixPlugins.getInstance().registerEventNotifier(eventNotifier);
            HystrixPlugins.getInstance().registerMetricsPublisher(metricsPublisher);
            HystrixPlugins.getInstance().registerPropertiesStrategy(propertiesStrategy);
        }

        public static class CustomHystrixConcurrentStrategy extends HystrixConcurrencyStrategy {
            private final HystrixConcurrencyStrategy delegate;

            CustomHystrixConcurrentStrategy(HystrixConcurrencyStrategy strategy) {
                this.delegate = strategy;
            }

            @Override
            public <T> Callable<T> wrapCallable(Callable<T> callable) {
                Callable<T> delegateCallable = delegate != null ? delegate.wrapCallable(callable) : super.wrapCallable(callable);
                return new MdcAwareCallable<>(delegateCallable, MDC.getCopyOfContextMap());
            }

            private static class MdcAwareCallable<T> implements Callable<T> {
                private final Callable<T> delegate;
                private final Map<String, String> context;

                public MdcAwareCallable(Callable<T> callable, Map<String, String> map) {
                    this.context = map != null ? map : new HashMap<>();
                    this.delegate = callable;
                }

                @Override
                public T call() throws Exception {
                    try {
                        MDC.setContextMap(context);
                        return delegate.call();
                    } finally {
                        for (String key : context.keySet())
                            MDC.remove(key);
                    }
                }
            }
        }
    }

}
