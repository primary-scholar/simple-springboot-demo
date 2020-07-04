package com.mimu.springboot.mybatis.demo.service;

import com.mimu.springboot.mybatis.demo.mapper.school.SchoolDataMapper;
import com.mimu.springboot.mybatis.demo.model.SchoolSchoolInfo;
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
    private SchoolDataMapper schoolDataMapper;

    @Autowired
    public void setSchoolDataMapper(SchoolDataMapper schoolDataMapper) {
        this.schoolDataMapper = schoolDataMapper;
    }

    public SchoolSchoolInfo getSchoolInfo(int serial) {
        SchoolSchoolInfo schoolInfo = schoolDataMapper.getSchoolInfo(serial);
        logger.info("{}", schoolInfo);
        return schoolInfo;
    }
}
