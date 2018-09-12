package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.AuthorSettings;

@RestController
@SpringBootApplication(scanBasePackages = {"com.model.**"})
public class SpringBootValueApplication {

	@Autowired
	private AuthorSettings authorSettings;
	
	@RequestMapping("/")
	public String index() {
		return "author name is : " + authorSettings.getName() + " and author age is : " + authorSettings.getAge();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootValueApplication.class, args);
	}
}
