package com.mimu.springboot.dubbo.api.api;


import com.mimu.springboot.dubbo.api.model.HelloData;

/**
 * author: mimu
 * date: 2019/9/18
 */
public interface HelloStringApi {
    HelloData hello(String name) throws Exception;
}
