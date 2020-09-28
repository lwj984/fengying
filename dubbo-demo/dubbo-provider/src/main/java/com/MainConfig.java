package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.dubbo.mapper")
@ImportResource({"classpath:dubbo/*.xml" })
public class MainConfig {

	public static void main(String[] args) {
		SpringApplication.run(MainConfig.class, args);  
	}
}
