package com.mimu.springboot.dubbo.consumer.service;

import com.mimu.springboot.dubbo.api.api.SchoolDataApi;
import com.mimu.springboot.dubbo.api.model.SchoolData;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * author: mimu
 * date: 2019/8/18
 */
@Service
public class CommonService {

    @DubboReference(check = false)
    private SchoolDataApi schoolDataApi;

    public SchoolData getSchoolData(int serial) {
        return schoolDataApi.getSchoolInfo(serial);
    }
}
