package com.mimu.springboot.dubbo.api.api;


import com.mimu.springboot.dubbo.api.model.SchoolData;

/**
 * author: mimu
 * date: 2019/8/18
 */
public interface SchoolDataApi {
    SchoolData getSchoolInfo(int serial);
}
