package com.mimu.springboot.demo.service;

import com.mimu.springboot.demo.dao.SchoolRepository;
import com.mimu.springboot.demo.model.SchoolSchoolInfo;
import com.mimu.springboot.demo.request.SchoolRequest;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
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

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "3000"),
            @HystrixProperty(name = HystrixPropertiesManager.FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value = "10")
    },
            threadPoolProperties = {
                    @HystrixProperty(name = HystrixPropertiesManager.CORE_SIZE, value = "10"),
                    @HystrixProperty(name = HystrixPropertiesManager.MAX_QUEUE_SIZE, value = "-1")
            }, fallbackMethod = "getSchoolInfoFallback")
    public SchoolSchoolInfo getSchoolInfo(SchoolRequest request) {
        SchoolSchoolInfo schoolInfo = schoolRepository.getSchoolInfo(request.getSerial());
        logger.info("{}", schoolInfo);
        return schoolInfo;
    }

    private SchoolSchoolInfo getSchoolInfoFallback(SchoolRequest request, Throwable throwable) {
        logger.info("hystrix fallback", throwable);
        return new SchoolSchoolInfo();
    }
}
