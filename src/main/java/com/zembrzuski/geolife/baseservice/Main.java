package com.zembrzuski.geolife.baseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Main {

	@Bean
	public RestTemplate verrySimpleRestTemplateBuilder() {
		return new RestTemplateBuilder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
