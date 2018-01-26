package com.jimbrighter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@Profile("aws")
public class WebConfigAWS extends BaseWebConfig {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/images/**")
				.allowedOrigins("*");
		registry.addMapping("/health")
				.allowedOrigins("*");
		registry.addMapping("/admin/**")
				.allowedOrigins("http://photodump.xyz");
	}
}
