package com.shreyash.demo;

import com.shreyash.demo.Features.Swiggy.Models.Restaurants;
import com.shreyash.demo.Features.Swiggy.Service.RestaurantCrudRepository;
import com.shreyash.demo.Features.Swiggy.Service.RestaurantRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

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
	SessionFactory sessionFactory;

	@Autowired
	RestaurantCrudRepository restaurantCrudRepository;

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


		persistWithHibernate();
	}

	// crud operations : create, read, update and delete



	public void persistWithHibernate(){

		// Entity Manager : JPA
		// Session : Hibernate

		// Entity Manager Factory : JPA
		// Session Factory : Hibernate

		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");

		Restaurants sagarRatna = new Restaurants("Sagar Ratna Malvia Nagar", "100017", "South Indian");
		restaurantCrudRepository.save(sagarRatna);
		sagarRatna.setRating(4);
		restaurantCrudRepository.save(sagarRatna);


		session.close();
		session.close();

	}




}


