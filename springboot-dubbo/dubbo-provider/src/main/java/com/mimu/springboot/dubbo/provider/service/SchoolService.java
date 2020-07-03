package com.mimu.springboot.dubbo.provider.service;

import com.mimu.springboot.dubbo.provider.dao.SchoolRepository;
import com.mimu.springboot.dubbo.provider.model.SchoolSchoolInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author: mimu
 * date: 2020/4/16
 */
@Service
public class SchoolService {
    private static final Logger logger = LoggerFactory.getLogger(SchoolService.class);
    private SchoolRepository schoolRepository;

    @Autowired
    public void setSchoolRepository(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public SchoolSchoolInfo getSchoolInfo(int serial) {
        SchoolSchoolInfo schoolInfo = schoolRepository.getSchoolInfo(serial);
        logger.info("{}", schoolInfo);
        return schoolInfo;
    }
}
