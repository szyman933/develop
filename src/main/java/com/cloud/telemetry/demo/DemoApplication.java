package com.cloud.telemetry.demo;

import org.hyperic.sigar.Sigar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class DemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);



	}












}



