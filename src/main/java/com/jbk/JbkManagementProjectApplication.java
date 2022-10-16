package com.jbk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class JbkManagementProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JbkManagementProjectApplication.class, args);
	}
	
	@Bean
	public CommonsMultipartResolver commonsMultiprtResolver() {
		return new CommonsMultipartResolver();
	}

}
