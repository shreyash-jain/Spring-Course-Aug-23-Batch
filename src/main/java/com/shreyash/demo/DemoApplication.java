package com.shreyash.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
@PropertySource("classpath:new.properties")
@EnableScheduling
public class DemoApplication implements ApplicationRunner {

	@Value("${app.me}")
	private String audience;

	java.sql.Connection connection;


	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {
		System.out.println("Dello");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Trello");

	}


	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println(audience);

		Notification n = applicationContext.getBean(Notification.class);
		n.sendMessage("Hello");

		persistData();


	}

	public void persistData() {

		try {

			java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy", "foo", "bar");

			PreparedStatement stmt = connection.prepareStatement("INSERT INTO RESTURANTS (ID, RATING) VALUES (?, ?)");
			stmt.setString(1, "9");
			stmt.setString(2,"2");
			stmt.executeUpdate();

			stmt.close();


		}
		catch (SQLException e) { e.printStackTrace(); } finally { try { connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	}


}


