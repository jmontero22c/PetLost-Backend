package com.petlost.petlost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PetlostApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetlostApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/mascotas").allowedOrigins("*");
				registry.addMapping("/mascotas/add").allowedOrigins("*");
				registry.addMapping("/personas/info").allowedOrigins("*");
				registry.addMapping("/contactos/info").allowedOrigins("*");
				registry.addMapping("/login").allowedOrigins("*");
			}
		};
	}

}
