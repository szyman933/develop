package com.cloud.telemetry.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class DemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);





	}












}



