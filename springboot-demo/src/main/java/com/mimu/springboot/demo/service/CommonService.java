package com.mimu.springboot.demo.service;

import com.mimu.springboot.demo.dao.SchoolRepository;
import com.mimu.springboot.demo.dao.StudentRepository;
import com.mimu.springboot.demo.model.TermInfo;
import com.mimu.springboot.demo.model.UserInfo;
import com.mimu.springboot.demo.request.UserInfoRequest;
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

    public UserInfo getUserInfo(int pid) {
        return studentRepository.getUserInfo(pid);
    }

    public TermInfo getTermInfo(int pid) {
        return schoolRepository.getTermInfo(pid);
    }

    @Transactional(transactionManager = "userTxManager", rollbackFor = RuntimeException.class)
    public boolean updateInfo(int pid, String nickName, int termId) {
        return addTermInfo1(pid, termId) && addUserInfo(pid, nickName);
    }

    public UserInfo getUserInfo(UserInfoRequest request) {
        UserInfo userInfo = studentRepository.getUserInfo(request.getPid());
        logger.info("{}", userInfo);
        return userInfo;
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
