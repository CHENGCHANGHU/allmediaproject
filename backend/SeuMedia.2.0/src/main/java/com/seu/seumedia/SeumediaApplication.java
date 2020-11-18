package com.seu.seumedia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.seu.seumedia.mapper")
public class SeumediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeumediaApplication.class, args);
	}

}
