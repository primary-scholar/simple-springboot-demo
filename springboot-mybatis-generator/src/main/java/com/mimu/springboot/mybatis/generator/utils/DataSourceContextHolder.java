package com.mimu.springboot.mybatis.generator.utils;

import com.mimu.springboot.mybatis.generator.enums.DataSourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: mimu
 * date: 2019/12/18
 */
public class DataSourceContextHolder {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceContextHolder.class);
    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();
    private static final AtomicInteger counter = new AtomicInteger(0);

    private static void setDataSourceType(DataSourceType type) {
        contextHolder.set(type);
    }

    public static DataSourceType getDataSourceType() {
        return contextHolder.get();
    }

    private static void removeThread() {
        contextHolder.remove();
    }

    public static void master() {
        logger.info("set master datasource");
        setDataSourceType(DataSourceType.master);
    }

    /**
     * here if you have multiple slave datasource you can use AtomicInteger to
     * set which slave was set the slave
     * for example:
     * public static void slave() {
     * int index = counter.getAndIncrement() % 2;
     * if (counter.get() > 9999) {
     * counter.set(-1);
     * }
     * if (index == 0) {
     * set(DataSourceType.SLAVE1);
     * }else {
     * set(DataSourceType.SLAVE2);
     * }
     * }
     */
    public static void slave() {
        logger.info("set slave datasource");
        setDataSourceType(DataSourceType.slave);
    }

    public static void remove() {
        logger.info("remove {} thread", contextHolder.get());
        removeThread();
    }
}
