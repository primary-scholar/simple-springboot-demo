package com.mimu.springboot.dubbo.consumer.service;

import com.mimu.springboot.dubbo.api.api.UserDataApi;
import com.mimu.springboot.dubbo.api.model.UserData;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * author: mimu
 * date: 2019/8/18
 */
@Service
public class CommonService {

    @DubboReference(check = false)
    private UserDataApi userDataApi;

    public UserData getUserData(long pid) {
        return userDataApi.getUserData(pid);
    }
}
