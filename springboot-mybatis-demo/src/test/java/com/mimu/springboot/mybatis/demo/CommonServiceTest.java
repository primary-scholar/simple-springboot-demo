package com.mimu.springboot.mybatis.demo;


import com.mimu.springboot.mybatis.demo.config.ApplicationConfig;
import com.mimu.springboot.mybatis.demo.mapper.school.SchoolDataMapper;
import com.mimu.springboot.mybatis.demo.mapper.student.StudentDataMapper;
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

    private SchoolDataMapper schoolDataMapper;
    private StudentDataMapper studentDataMapper;

    @Autowired
    public void setSchoolDataMapper(SchoolDataMapper schoolDataMapper) {
        this.schoolDataMapper = schoolDataMapper;
    }

    @Autowired
    public void setStudentDataMapper(StudentDataMapper studentDataMapper) {
        this.studentDataMapper = studentDataMapper;
    }

    @Test
    public void info() {
        System.out.println(schoolDataMapper.getSchoolInfo(1));
    }

    @Test
    public void info1() {
        System.out.println(studentDataMapper.getStudentInfo(20));
    }
}
