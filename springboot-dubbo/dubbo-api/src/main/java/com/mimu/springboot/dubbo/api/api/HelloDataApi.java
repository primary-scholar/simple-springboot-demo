package com.mimu.springboot.dubbo.api.api;


import com.mimu.springboot.dubbo.api.model.HelloData;

import java.util.concurrent.CompletableFuture;

/**
 * author: mimu
 * date: 2019/9/18
 */
public interface HelloDataApi {
    HelloData hello(String name) throws Exception;

    CompletableFuture<HelloData> asyncHello(String name);
}
