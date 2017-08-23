package com.oreally.cloud;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@RestController
public class SpringMicroserviceApplication {
	
	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}
	
	@Bean
	public ServletRegistrationBean registration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(), "/servlet/*");
		registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME);
		return registration;
	}

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
