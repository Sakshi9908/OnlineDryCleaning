package com.onlinedrycleaning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@RestController
@OpenAPIDefinition(info = @Info(title = "OnlineDryCleaning API", version = "1.0", description = "An API used for Dry cleaning."))
public class OnlineDryCleaningApplication {

	Logger log = LoggerFactory.getLogger(OnlineDryCleaningApplication.class);

	@GetMapping("/test/{name}")
	public String greeting(@PathVariable String name) {

		log.debug("Request {}", name);

		if (name.equalsIgnoreCase("test")) {
			throw new RuntimeException("Exception raised.");
		}

		String response = "Hello " + name + " Welcome to Dry cleaning Application";
		log.debug("Response {}", response);
		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(OnlineDryCleaningApplication.class, args);
		System.out.println("Application Started...!!!!!");
	}
}
