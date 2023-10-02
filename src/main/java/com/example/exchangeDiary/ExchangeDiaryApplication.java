package com.example.exchangeDiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ExchangeDiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeDiaryApplication.class, args);
	}

}
