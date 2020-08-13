package com.mimu.springboot.hystrix.demo.service;

import com.mimu.springboot.hystrix.demo.model.SchoolSchoolInfo;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient
public interface ICommonService {

    public SchoolSchoolInfo getSchoolInfo();

    public SchoolSchoolInfo delSchoolInfo();
}
