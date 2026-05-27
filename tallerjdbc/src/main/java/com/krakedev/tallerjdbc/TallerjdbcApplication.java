package com.krakedev.tallerjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;

@SpringBootApplication(scanBasePackages = "com.krakedev" )
@EnableJpaRepositories(basePackages = "com.krakedev")
@EntityScan(basePackages = "com.krakedev")
public class TallerjdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerjdbcApplication.class, args);
	}

}
