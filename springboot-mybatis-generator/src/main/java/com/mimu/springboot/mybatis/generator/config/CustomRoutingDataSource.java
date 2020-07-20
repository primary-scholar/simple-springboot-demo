package com.mimu.springboot.mybatis.generator.config;

import com.mimu.springboot.mybatis.generator.utils.DataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 author: mimu
 date: 2019/12/18
 */
public class CustomRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSourceType();
    }
}
