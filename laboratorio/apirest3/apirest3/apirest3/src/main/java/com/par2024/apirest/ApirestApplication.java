package com.par2024.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class ApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
	}

	@Bean
	public OpenAPI customApi(){
		return new OpenAPI()
				.info(new Info()
				.title("PAR2024 - Spring Boot API")
				.description("Ejemplo API REST con Sping Boot + Swagger")
				);
	}

}
