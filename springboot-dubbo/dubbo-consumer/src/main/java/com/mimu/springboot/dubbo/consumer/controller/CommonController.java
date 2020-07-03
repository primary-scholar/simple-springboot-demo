package com.mimu.springboot.dubbo.consumer.controller;

import com.mimu.springboot.dubbo.api.model.SchoolData;
import com.mimu.springboot.dubbo.consumer.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: mimu
 * date: 2019/10/12
 */
@RestController
public class CommonController {
    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    private CommonService commonService;

    @Autowired
    public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }

    @RequestMapping(value = "/consumer/school.do", method = RequestMethod.GET)
    public SchoolData getSchoolData(int serial) {
        SchoolData schoolData = commonService.getSchoolData(serial);
        logger.info("schoolData={}", schoolData);
        return schoolData;
    }
}
