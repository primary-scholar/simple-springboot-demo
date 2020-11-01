package com.mimu.springboot.dubbo.consumer.service;

import com.mimu.springboot.dubbo.api.api.HelloDataApi;
import com.mimu.springboot.dubbo.api.api.SchoolDataApi;
import com.mimu.springboot.dubbo.api.model.HelloData;
import com.mimu.springboot.dubbo.api.model.SchoolData;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * author: mimu
 * date: 2019/8/18
 */
@Service
public class CommonService {
    private static final Logger logger = LoggerFactory.getLogger(CommonService.class);

    @DubboReference(check = false)
    private SchoolDataApi schoolDataApi;

    @DubboReference(check = false, async = true)
    private HelloDataApi helloDataApi;

    public SchoolData getSchoolData(int serial) {
        return schoolDataApi.getSchoolInfo(serial);
    }

    public HelloData getHelloData(String name) throws ExecutionException, InterruptedException {
        CompletableFuture<HelloData> helloDataCompletableFuture = helloDataApi.asyncHello(name);
        logger.info("async wait...{}", System.currentTimeMillis());
        while (!helloDataCompletableFuture.isDone()) {
        }
        logger.info("async over...{}", System.currentTimeMillis());
        return helloDataCompletableFuture.get();
    }
}
