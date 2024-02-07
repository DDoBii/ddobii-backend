package com.ddobii.back.ddobii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DdobiiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DdobiiApplication.class, args);

		System.out.print("jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_SCHEMA}?serverTimezone=UTC&characterEncoding=UTF-8");
		
	}

}
