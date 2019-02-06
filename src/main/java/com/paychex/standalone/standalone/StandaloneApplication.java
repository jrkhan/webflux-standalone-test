package com.paychex.standalone.standalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class StandaloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(StandaloneApplication.class, args);
	}

}

