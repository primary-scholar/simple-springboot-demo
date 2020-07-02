package com.mimu.springboot.mybatis.demo.config;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.mimu.springboot.mybatis.demo.mapper.term.TermDataMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * author: mimu
 * date: 2019/8/1
 */

/**
 * 使用了 @MapperScan 就可以不再 各个 *Mapper 的类上 标注 @Mapper 注解了
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackageClasses = TermDataMapper.class, sqlSessionFactoryRef = "termSqlSessionFactory")
public class TermInfoDataSourceConfig {
    private static final Logger logger = LoggerFactory.getLogger(TermInfoDataSourceConfig.class);

    /**
     * generate datasource
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "term.datasource")
    public DataSource termDataSource() {
        logger.info("init termDataSource");
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * generate db transactionManager bean
     *
     * @param termDataSource
     * @return
     */
    @Bean
    @Resource
    public PlatformTransactionManager termDataSourceTxManager(DataSource termDataSource) {
        return new DataSourceTransactionManager(termDataSource);
    }

    @Bean
    @Resource
    public SqlSessionFactory termSqlSessionFactory(DataSource termDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(termDataSource);
        sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return sqlSessionFactory.getObject();
    }
}
