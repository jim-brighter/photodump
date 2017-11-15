package com.jimbrighter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class PhotodumpApplication {

	public PhotodumpApplication() {
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PhotodumpApplication.class, args);
	}
}
