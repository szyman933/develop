package com.cloud.telemetry.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
@Configuration
@EnableJpaRepositories(basePackages = "com.cloud.telemetry.demo")

public class AppConfig {

    private static String url;
    private static String user;
    private static String password;

    private static Properties prop = new Properties();
    private static InputStream input = null;

    static {
        try {
            input = new FileInputStream("src/main/resources/db.properties");
            prop.load(input);
            url = prop.getProperty("url");
            user = prop.getProperty("login");
            password = prop.getProperty("password");
            input.close();

        } catch (IOException ex) {
            log.error("Can't find or open a file ", ex);
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
