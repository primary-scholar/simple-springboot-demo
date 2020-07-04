package com.mimu.springboot.mybatis.generator.service;


import com.mimu.springboot.mybatis.generator.config.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class, MybatisAutoConfiguration.class})
@Import(value = {ApplicationConfig.class})
public class CommonServiceTest {
    @Autowired
    private CommonService commonService;

    /**
     * this method will be error
     * because commonService.getSchoolInfo()
     * will use slave datasource(education_student),
     * while the slave datasource hasn't table School_info
     * so it will be error
     */
    @Test
    public void getSchoolInfo() {
        System.out.println(commonService.getSchoolInfo(8));
    }

    @Test
    public void getStudentInfo() throws InterruptedException {
        System.out.println(commonService.getStudentInfo(1));
    }
}