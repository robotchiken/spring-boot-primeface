package com.takuba.comics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.takuba.comics")
@SpringBootApplication
public class ComicsWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComicsWsApplication.class, args);
	}
}
