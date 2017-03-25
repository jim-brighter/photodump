package com.jimbrighter;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class PhotodumpApplication {

	public PhotodumpApplication() {
		
	}
	
	@Bean
	@Autowired
	public SessionFactory sessionFactory(EntityManagerFactory fac) {
		return fac.unwrap(SessionFactory.class);
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PhotodumpApplication.class, args);
	}
}
