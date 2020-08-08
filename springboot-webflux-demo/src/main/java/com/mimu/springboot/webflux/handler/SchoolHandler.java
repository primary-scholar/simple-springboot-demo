package com.mimu.springboot.webflux.handler;

import com.mimu.springboot.webflux.model.SchoolSchoolInfo;
import com.mimu.springboot.webflux.repository.SchoolRepository;
import com.mimu.springboot.webflux.request.SchoolRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * author: mimu
 * date: 2020/4/16
 */
@Service
public class SchoolHandler {
    private static final Logger logger = LoggerFactory.getLogger(SchoolHandler.class);
    private SchoolRepository schoolRepository;
    private RestTemplate restTemplate;

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
