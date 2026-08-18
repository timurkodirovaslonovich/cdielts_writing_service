package com.cdielts.writing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WritingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WritingApplication.class, args);
		System.out.println("Server is running on http://localhost:8080/swagger-ui.html");
	}

}
