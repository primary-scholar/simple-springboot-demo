/*
package com.mimu.springboot.dubbo.provider.controller;

import com.mimu.springboot.dubbo.api.model.SchoolData;
import com.mimu.springboot.dubbo.provider.model.SchoolSchoolInfo;
import com.mimu.springboot.dubbo.provider.service.SchoolService;
import com.mimu.springboot.dubbo.provider.service.dubbo.SchoolDataApiImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * author: mimu
 * date: 2019/6/29
 *//*

@RestController
public class SchoolController {
    private static final Logger logger = LoggerFactory.getLogger(SchoolController.class);
    private SchoolDataApiImpl schoolDataApi;
    private SchoolService schoolService;

    @Autowired
    public void setSchoolDataApi(SchoolDataApiImpl schoolDataApi) {
        this.schoolDataApi = schoolDataApi;
    }

    @Autowired
    public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @RequestMapping(value = "/provider/school.do", method = RequestMethod.GET)
    public SchoolSchoolInfo getUserData(int serial) {
        SchoolSchoolInfo schoolInfo = schoolService.getSchoolInfo(serial);
        logger.info("request={},result={}", serial, schoolInfo);
        return schoolInfo;
    }
}
*/
