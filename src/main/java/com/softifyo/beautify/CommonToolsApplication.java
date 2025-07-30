package com.softifyo.beautify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class CommonToolsApplication {

	@GetMapping(path = "/v1")
	public String greetMessage() {
		return "Hello...! How are you?";
	}

	public static void main(String[] args) {
		SpringApplication.run(CommonToolsApplication.class, args);
	}

}
