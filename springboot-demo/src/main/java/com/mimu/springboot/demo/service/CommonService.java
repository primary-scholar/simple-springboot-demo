package com.mimu.springboot.demo.service;

import com.mimu.springboot.demo.dao.SchoolRepository;
import com.mimu.springboot.demo.dao.StudentRepository;
import com.mimu.springboot.demo.model.SchoolSchoolInfo;
import com.mimu.springboot.demo.model.StudentStudentInfo;
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

    public SchoolSchoolInfo getSchoolInfo(int serial) {
        SchoolSchoolInfo schoolInfo = schoolRepository.getSchoolInfo(serial);
        logger.info("{}", schoolInfo);
        return schoolInfo;
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
