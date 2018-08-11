package com.cloud.telemetry.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages="com.cloud.telemetry.demo")

public class AppConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ret = new DriverManagerDataSource();
        ret.setDriverClassName("com.mysql.jdbc.Driver");
        ret.setUsername("daniel");
        ret.setPassword("daniel");
        ret.setUrl("jdbc:mysql://192.168.1.112:3306/daniel?autoReconnect=true&useSSL=false");

        return ret;
    }





}
