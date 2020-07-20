package com.mimu.springboot.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author: mimu
 * date: 2019/10/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonServiceTest {

    @Autowired
    private CommonService commonService;

    @Test
    public void getSchoolInfo() {
        System.out.println(commonService.getSchoolInfo(10001));
    }

    @Test
    public void getStudentInfo() {
        System.out.println(commonService.getStudentInfo(1));
    }
}