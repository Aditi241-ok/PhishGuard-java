package com.phishingdetector.phishing_email_detector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Annotations provide additional information/instructions to Java frameworks.
//This is the main Spring Boot application. Configure and start the application.
public class PhishingEmailDetectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhishingEmailDetectorApplication.class, args);

	}

}
