package com.cgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@EnableCaching
@SpringBootConfiguration
public class CGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(CGameApplication.class, args);
	}

}