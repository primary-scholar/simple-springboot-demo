package com.mimu.springboot.dubbo.provider.service.dubbo;

import com.mimu.springboot.dubbo.api.api.HelloDataApi;
import com.mimu.springboot.dubbo.api.model.HelloData;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * author: mimu
 * date: 2019/9/18
 */
@Component
@DubboService(interfaceClass = HelloDataApi.class, timeout = 100)
public class HelloDataApiImpl implements HelloDataApi {
    private static final Logger logger = LoggerFactory.getLogger(HelloDataApiImpl.class);

    @Override
    public HelloData hello(String name) throws Exception {
        HelloData build = new HelloData(name);
        logger.info("data={}", build);
        return build;
    }
}
