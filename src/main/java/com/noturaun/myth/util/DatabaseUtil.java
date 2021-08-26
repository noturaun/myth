package com.noturaun.myth.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {

    private static final HikariDataSource dataSource;
    static {
        String configUrl = "src/main/resources/config.properties";
        HikariConfig config = new HikariConfig(configUrl);
        dataSource = new HikariDataSource(config);
    }
    public static HikariDataSource getDataSource(){
        return dataSource;
    }
}
