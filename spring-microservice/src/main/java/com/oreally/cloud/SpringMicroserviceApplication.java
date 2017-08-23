package com.oreally.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringMicroserviceApplication {

	@RequestMapping("/")
	public String greetings() {
		return "Hello World!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceApplication.class, args);
	}
}
