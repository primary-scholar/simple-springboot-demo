package com.mimu.springboot.webflux.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * author: mimu
 * date: 2019/7/5
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class AppDataSourceConfig {
    private static final Logger logger = LoggerFactory.getLogger(AppDataSourceConfig.class);

    /**
     * generate datasource properties bean
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "school.datasource")
    public DataSourceProperties schoolDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "student.datasource")
    public DataSourceProperties studentDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * generate datasource bean
     *
     * @return
     */
    @Bean
    public DataSource schoolDataSource() {
        DataSourceProperties properties = schoolDataSourceProperties();
        logger.info("init schoolDataSource");
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean
    public DataSource studentDataSource(DataSourceProperties studentDataSourceProperties) {
        logger.info("init studentDataSource");
        return studentDataSourceProperties.initializeDataSourceBuilder().build();
    }

    /**
     * generate db transactionManager bean
     *
     * @param
     * @return
     */
    @Bean
    public PlatformTransactionManager schoolTxManager(DataSource schoolDataSource) {
        return new DataSourceTransactionManager(schoolDataSource);
    }

    @Bean
    public PlatformTransactionManager studentTxManager(DataSource studentDataSource) {
        return new DataSourceTransactionManager(studentDataSource);
    }

    /**
     * generate jdbcTemplate bean
     *
     * @param schoolDataSource
     * @return
     */
    @Bean
    @Autowired
    public JdbcTemplate schoolJdbcTemplate(DataSource schoolDataSource) {
        return new JdbcTemplate(schoolDataSource);
    }

    @Bean
    @Autowired
    public JdbcTemplate studentJdbcTemplate(DataSource studentDataSource) {
        return new JdbcTemplate(studentDataSource);
    }

}
