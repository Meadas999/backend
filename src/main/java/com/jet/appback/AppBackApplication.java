package com.jet.appback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AppBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppBackApplication.class, args);
	}

}
