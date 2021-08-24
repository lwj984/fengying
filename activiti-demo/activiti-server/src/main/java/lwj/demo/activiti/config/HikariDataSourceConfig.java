/*
 * Copyright (c) 2020, Jiehun.com.cn Inc. All Rights Reserved
 */
package lwj.demo.activiti.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class HikariDataSourceConfig {

    @Value("${activiti.datasource.minimum-idle}")
    private int minIdle;

    @Value("${activiti.datasource.maximum-pool-size}")
    private int maxPoolSize;

    @Value("${activiti.datasource.max-lifetime}")
    private int maxLifeTime;

    @Value("${activiti.datasource.connection-timeout}")
    private int connectionTimeout;

    @Value("${activiti.datasource.idle-timeout}")
    private int idleTimeout;

    @Value("${activiti.datasource.connection-test-query}")
    private String connectionTestQuery;

    @Value("${activiti.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${activiti.datasource.activiti-server.jdbcUrl}")
    private String activitiDbUrl;

    @Value("${activiti.datasource.activiti-server.username}")
    private String activitiUsername;

    @Value("${activiti.datasource.activiti-server.password}")
    private String activitiPassword;

    /**
     * 声明其为Bean实例 在同样的DataSource中，首先使用被标注的DataSource
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        HikariDataSource datasource = new HikariDataSource();
        datasource.setUsername(activitiUsername);
        datasource.setPassword(activitiPassword);
        datasource.setDriverClassName(driverClassName);
        datasource.setJdbcUrl(activitiDbUrl);
        datasource.setMinimumIdle(minIdle);
        datasource.setMaximumPoolSize(maxPoolSize);
        datasource.setMaxLifetime(maxLifeTime);
        datasource.setConnectionTimeout(connectionTimeout);
        datasource.setIdleTimeout(idleTimeout);
        datasource.setConnectionTestQuery(connectionTestQuery);
        log.info("---------------dataSource init success---------------");
        return datasource;
    }
}
