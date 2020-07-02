package com.mimu.springboot.dubbo.api.api;


import com.mimu.springboot.dubbo.api.model.UserData;

/**
 * author: mimu
 * date: 2019/8/18
 */
public interface UserDataApi {

    UserData getUserData(long pid);
}
