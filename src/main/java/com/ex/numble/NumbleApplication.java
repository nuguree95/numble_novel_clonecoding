package com.ex.numble;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan(basePackages = {"com.ex.numble.mapper"})
@EnableCaching
@EnableScheduling
@SpringBootApplication
public class NumbleApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumbleApplication.class, args);
	}

}
