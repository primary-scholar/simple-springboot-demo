package com.mimu.springboot.demo.service;

import com.mimu.springboot.demo.model.StudentStudentInfo;
import com.mimu.springboot.demo.request.StudentRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author: mimu
 * date: 2020/4/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    public StudentRequest getRequest() {
        StudentRequest request = new StudentRequest();
        request.setNo(1);
        request.setName("tom");
        return request;
    }

    @Test
    public void getUserInfo() {
        StudentStudentInfo studentInfoCacheableEquivalent = studentService.getStudentInfoCacheableEquivalent(getRequest());
        System.out.println(studentInfoCacheableEquivalent);
    }

}