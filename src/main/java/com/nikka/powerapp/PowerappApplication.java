package com.nikka.powerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync(proxyTargetClass = true)
public class PowerappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PowerappApplication.class, args);
	}


	//Test
}
