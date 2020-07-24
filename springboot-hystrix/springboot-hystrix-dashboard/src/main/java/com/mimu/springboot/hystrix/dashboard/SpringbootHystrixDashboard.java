package com.mimu.springboot.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class SpringbootHystrixDashboard {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootHystrixDashboard.class, args);
    }
}
