package com.shreyash.demo;

import com.shreyash.demo.Features.Swiggy.Models.Address;
import com.shreyash.demo.Features.Swiggy.Models.FoodItem;
import com.shreyash.demo.Features.Swiggy.Models.Restaurants;
import com.shreyash.demo.Features.Swiggy.Service.FoodItemCrudRepository;
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
import java.util.ArrayList;
import java.util.Arrays;
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
	FoodItemCrudRepository foodItemCrudRepository;

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

		Address address = new Address("110017", "Delhi");
		Restaurants sagarRatna = new Restaurants("Sagar Ratna with food items", address, "South Indian");

		FoodItem pavBhaji = new FoodItem("Pav Bhaji", "Indian");
		FoodItem burger = new FoodItem("Burger", "Indian");

		List<FoodItem> foodItems =  Arrays.asList(pavBhaji, burger);
		sagarRatna.setFoodItems(foodItems);
		restaurantCrudRepository.save(sagarRatna);



		// Owner - the entity that should be changed -> Inverse End also changes
		// Inverse End - Address

		session.close();
		session.close();

	}




}


