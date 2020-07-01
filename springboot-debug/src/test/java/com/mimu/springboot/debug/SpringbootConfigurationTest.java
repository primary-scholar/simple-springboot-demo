package com.mimu.springboot.debug;

import com.mimu.springboot.debug.configurations.ModelDependency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 author: mimu
 date: 2020/4/22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootConfigurationTest {

    @Autowired
    private ModelDependency modelDependency;

    @Test
    public void info() {
        System.out.println(modelDependency.getModelProperty());
    }
}
