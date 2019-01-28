package com.cloud.telemetry.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.cloud.telemetry.demo")

public class AppConfig {

    private static String url;
    private static String user;
    private static String password;

    public static Properties prop = new Properties();
    static InputStream input = null;

    static {
        try {
            input = new FileInputStream("db.properties");
            prop.load(input);
            url = prop.getProperty("url");
            user = prop.getProperty("login");
            password = prop.getProperty("password");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource ret = new DriverManagerDataSource();
        ret.setDriverClassName("com.mysql.jdbc.Driver");
        ret.setUsername(user);
        ret.setPassword(password);
        ret.setUrl(url);

        return ret;
    }

}
