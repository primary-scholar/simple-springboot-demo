package com.mimu.springboot.mybatis.generator.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.mimu.springboot.mybatis.generator.enums.DataSourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * author: mimu
 * date: 2019/12/18
 */
@Configuration
public class DataSourceConfig {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    /**
     * generate user datasource as master
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "school.datasource")
    public DataSource schoolDataSourceAsMaster() {
        logger.info("init schoolDataSourceAsMaster");
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * generate term datasource as slave
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "student.datasource")
    public DataSource studentDataSourceAsSlave() {
        logger.info("init studentDataSourceAsSlave");
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * generate the routing datasource which has contain two kind of datasource
     * the first type is routing source contains two datasource one master and one slave
     * the second type is general datasource master or slave
     *
     * @param schoolDataSourceAsMaster
     * @param studentDataSourceAsSlave
     * @return
     */
    @Bean
    public DataSource customRoutingDataSource(DataSource schoolDataSourceAsMaster, DataSource studentDataSourceAsSlave) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceType.master, schoolDataSourceAsMaster);
        targetDataSource.put(DataSourceType.slave, studentDataSourceAsSlave);
        CustomRoutingDataSource customRoutingDataSource = new CustomRoutingDataSource();
        customRoutingDataSource.setDefaultTargetDataSource(studentDataSourceAsSlave);
        customRoutingDataSource.setTargetDataSources(targetDataSource);
        return customRoutingDataSource;
    }
}
