package com.mimu.springboot.demo.service;

import com.mimu.springboot.demo.dao.SchoolRepository;
import com.mimu.springboot.demo.dao.StudentRepository;
import com.mimu.springboot.demo.model.SchoolSchoolInfo;
import com.mimu.springboot.demo.model.StudentStudentInfo;
import com.mimu.springboot.demo.request.SchoolRequest;
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

    @Transactional(transactionManager = "userTxManager", rollbackFor = RuntimeException.class)
    public boolean updateInfo(int pid, String nickName, int termId) {
        return addTermInfo1(pid, termId) && addUserInfo(pid, nickName);
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

    private boolean addTermInfo(int pid, int termId) {
        if (!schoolRepository.addTermInfo(pid, termId)) {
            throw new RuntimeException("insert termData error");
        } else {
            return true;
        }
    }

    private boolean addUserInfo(int pid, String nickName) {
        if (!studentRepository.addUserInfo(pid, nickName)) {
            throw new RuntimeException("insert termData error");
        } else {
            return true;
        }
    }

    private boolean addTermInfo1(long pid, int termId) {
        if (!studentRepository.addTermInfo(pid, termId)) {
            throw new RuntimeException("insert termData error");
        } else {
            return true;
        }
    }


}
