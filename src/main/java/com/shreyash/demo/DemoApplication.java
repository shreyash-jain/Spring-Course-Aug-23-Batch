package com.shreyash.demo;

import org.apache.catalina.core.StandardThreadExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@PropertySource("classpath:new.properties")
public class DemoApplication implements ApplicationRunner {

	@Value("${app.me}")
	private String audience;

	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {
		System.out.println("Dello");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Trello");

	}

//	@Bean
//	public Notification getNotification(MessageService cello){
//		Notification n = new Notification();
//		n.thisService = cello;
//		return n;
//	}


	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println(audience);

		Notification n = applicationContext.getBean(Notification.class);
		n.sendMessage("Hello");
	}
}
