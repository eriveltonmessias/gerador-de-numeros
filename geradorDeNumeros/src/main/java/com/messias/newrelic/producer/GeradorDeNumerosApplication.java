package com.messias.newrelic.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GeradorDeNumerosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeradorDeNumerosApplication.class, args);
	}

}
