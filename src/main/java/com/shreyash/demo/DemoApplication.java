package com.shreyash.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {
	@Autowired
	private Notification service;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Trello");

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		service.sendMessage("Hello");
	}
}
