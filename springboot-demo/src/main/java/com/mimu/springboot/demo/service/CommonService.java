package com.mimu.springboot.demo.service;

import com.mimu.springboot.demo.dao.SchoolRepository;
import com.mimu.springboot.demo.dao.StudentRepository;
import com.mimu.springboot.demo.model.SchoolSchoolInfo;
import com.mimu.springboot.demo.model.StudentStudentInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author: mimu
 * date: 2019/7/5
 */
@Service
public class CommonService {
    private static final Logger logger = LoggerFactory.getLogger(CommonService.class);

    private SchoolRepository schoolRepository;
    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setSchoolRepository(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Transactional(transactionManager = "schoolTxManager", rollbackFor = RuntimeException.class)
    public boolean updateInfo(int serial, String schoolName, String schoolAddress, int no, String courseName, int hour) {
        return addSchoolInfo(serial, schoolName, schoolAddress) && addCourseInfo(no, courseName, hour);
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "1000"),
            @HystrixProperty(name = HystrixPropertiesManager.FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value = "1")
    },
            threadPoolProperties = {
                    @HystrixProperty(name = HystrixPropertiesManager.CORE_SIZE, value = "10"),
                    @HystrixProperty(name = HystrixPropertiesManager.MAX_QUEUE_SIZE, value = "-1")
            }, fallbackMethod = "getSchoolInfoFallback")
    public SchoolSchoolInfo getSchoolInfo(int serial) {
        SchoolSchoolInfo schoolInfo = schoolRepository.getSchoolInfo(serial);
        logger.info("{}", schoolInfo);
        return schoolInfo;
    }

    private SchoolSchoolInfo getSchoolInfoFallback(int serial, Throwable throwable) {
        logger.info("hystrix fallback", throwable);
        return new SchoolSchoolInfo();
    }

    public StudentStudentInfo getStudentInfo(int no) {
        StudentStudentInfo studentInfo = studentRepository.getStudentInfo(no);
        logger.info("{}", studentInfo);
        return studentInfo;
    }

    private boolean addSchoolInfo(int serial, String name, String address) {
        if (!schoolRepository.addSchoolInfo(serial, name, address)) {
            throw new RuntimeException("insert school error");
        } else {
            return true;
        }
    }

    private boolean addCourseInfo(int no, String name, int hour) {
        if (!schoolRepository.addCourseInfo(no, name, hour)) {
            throw new RuntimeException("insert course error");
        } else {
            return true;
        }
    }

}
