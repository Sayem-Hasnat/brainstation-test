package com.hasnat.bs23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Bs23Application {

	public static void main(String[] args) {
		SpringApplication.run(Bs23Application.class, args);
	}

}
