package com.example.websockets_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebsocketsExampleApplication {

	public static void main(String[] args) {
        SpringApplication.run(WebsocketsExampleApplication.class, args);
	}

}
