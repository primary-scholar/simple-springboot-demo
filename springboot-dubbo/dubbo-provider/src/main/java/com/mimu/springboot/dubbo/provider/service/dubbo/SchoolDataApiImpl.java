package com.mimu.springboot.dubbo.provider.service.dubbo;


import com.mimu.springboot.dubbo.api.api.SchoolDataApi;
import com.mimu.springboot.dubbo.api.model.SchoolData;
import com.mimu.springboot.dubbo.provider.dao.SchoolRepository;
import com.mimu.springboot.dubbo.provider.model.SchoolSchoolInfo;
import com.mimu.springboot.dubbo.provider.service.SchoolService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author: mimu
 * date: 2019/8/18
 */
@Component
@DubboService(interfaceClass = SchoolDataApi.class, timeout = 5000)
public class SchoolDataApiImpl implements SchoolDataApi {
    private SchoolService schoolService;

    @Autowired
    public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @Override
    public SchoolData getSchoolInfo(int no) {
        SchoolSchoolInfo schoolInfo = schoolService.getSchoolInfo(no);
        SchoolData data = new SchoolData();
        BeanUtils.copyProperties(schoolInfo, data);
        return data;
    }
}
