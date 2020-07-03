package com.mimu.springboot.demo.service;

import com.mimu.springboot.demo.request.SchoolRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SchoolServiceTest {

    @Autowired
    private SchoolService schoolService;

    public SchoolRequest getRequest() {
        SchoolRequest request = new SchoolRequest();
        request.setSerial(1);
        return request;
    }

    @Test
    public void getSchoolInfo() {
        System.out.println(schoolService.getSchoolInfo(getRequest()));
    }

}