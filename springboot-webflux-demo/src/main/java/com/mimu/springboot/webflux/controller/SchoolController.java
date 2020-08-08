package com.mimu.springboot.webflux.controller;

import com.mimu.springboot.webflux.handler.SchoolHandler;
import com.mimu.springboot.webflux.model.SchoolSchoolInfo;
import com.mimu.springboot.webflux.request.SchoolRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: mimu
 * date: 2019/6/29
 */
@RestController
public class SchoolController {
    private static final Logger logger = LoggerFactory.getLogger(SchoolController.class);
    private SchoolHandler schoolHandler;

    @Autowired
    public void setSchoolHandler(SchoolHandler schoolHandler) {
        this.schoolHandler = schoolHandler;
    }

    @RequestMapping(value = "/school.do", method = RequestMethod.GET)
    public SchoolSchoolInfo getUserData(SchoolRequest request) {
        SchoolSchoolInfo schoolInfo = schoolHandler.getSchoolInfo(request);
        logger.info("request={},result={}", request, schoolInfo);
        return schoolInfo;
    }
}
