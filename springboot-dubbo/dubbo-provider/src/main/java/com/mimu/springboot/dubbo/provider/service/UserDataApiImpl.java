package com.mimu.springboot.dubbo.provider.service;


import com.mimu.springboot.dubbo.api.api.UserDataApi;
import com.mimu.springboot.dubbo.api.model.UserData;
import com.mimu.springboot.dubbo.provider.dao.UserRepository;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author: mimu
 * date: 2019/8/18
 */
@Component
@DubboService(interfaceClass = UserDataApi.class, timeout = 5000)
public class UserDataApiImpl implements UserDataApi {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserData getUserData(long pid) {
        return userRepository.getUserData(pid);
    }
}
