package com.mimu.springboot.dubbo.provider.service;

import com.mimu.springboot.dubbo.api.api.HelloStringApi;
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
@DubboService(interfaceClass = HelloStringApi.class, timeout = 100)
public class HelloStringImpl implements HelloStringApi {
    private static final Logger logger = LoggerFactory.getLogger(HelloStringImpl.class);

    @Override
    public HelloData hello(String name) throws Exception {
        HelloData build = new HelloData(name);
        logger.info("data={}", build);
        return build;
    }
}
