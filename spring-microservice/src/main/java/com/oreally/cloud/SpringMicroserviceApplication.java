package com.oreally.cloud;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringMicroserviceApplication {

	@Autowired
	@Resource(name="cats")
	public List<String> list;
	
	@RequestMapping("/")
	public String greetings() {
		return String.join(", ", list);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceApplication.class, args);
	}
}
