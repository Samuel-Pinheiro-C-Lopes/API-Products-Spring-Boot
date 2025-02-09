package br.com.cadastro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.cadastro.service.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DBService service;

	/*
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("*")
		.allowedMethods("GET", "POST", "PUT", "DELETE")
		.allowedHeaders("*");
	}
	*/
	
    @Bean
    DBService initialize() {
		service.initializeDataBase();
		return service;
	}
}
