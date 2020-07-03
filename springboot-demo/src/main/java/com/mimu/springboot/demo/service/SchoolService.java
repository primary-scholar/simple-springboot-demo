package com.mimu.springboot.demo.service;

import com.mimu.springboot.demo.dao.SchoolRepository;
import com.mimu.springboot.demo.dao.StudentRepository;
import com.mimu.springboot.demo.model.SchoolSchoolInfo;
import com.mimu.springboot.demo.request.SchoolRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * author: mimu
 * date: 2020/4/16
 */
@Service
public class SchoolService {
    private static final Logger logger = LoggerFactory.getLogger(SchoolService.class);
    private StringRedisTemplate redisTemplate;
    private SchoolRepository schoolRepository;

    @Autowired
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Autowired
    public void setSchoolRepository(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public SchoolSchoolInfo getSchoolInfo(SchoolRequest request) {
        SchoolSchoolInfo schoolInfo = schoolRepository.getSchoolInfo(request.getSerial());
        logger.info("{}", schoolInfo);
        return schoolInfo;
    }
}
