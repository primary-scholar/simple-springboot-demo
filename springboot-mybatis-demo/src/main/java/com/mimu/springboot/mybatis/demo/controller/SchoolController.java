package com.mimu.springboot.mybatis.demo.controller;

import com.mimu.springboot.mybatis.demo.model.SchoolSchoolInfo;
import com.mimu.springboot.mybatis.demo.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
    private static final Logger logger = LoggerFactory.getLogger(SchoolController.class);

    private SchoolService schoolService;

    @Autowired
    public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @RequestMapping(value = "/school.do", method = RequestMethod.GET)
    public SchoolSchoolInfo getUserData(int serial) {
        SchoolSchoolInfo schoolInfo = schoolService.getSchoolInfo(serial);
        logger.info("request={},result={}", serial, schoolInfo);
        return schoolInfo;
    }
}
