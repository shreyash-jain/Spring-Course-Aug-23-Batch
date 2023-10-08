package com.shreyash.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	SessionFactory sessionFactory;

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

		persistWithJPA();
	}

	public void persistWithJPA(){
		// JPA - Hibernate
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		// Persistence Context
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//

		System.out.println("Starting Transaction");
		entityManager.getTransaction().begin();
		Restaurants restaurant = new Restaurants();
		// New - Transcient

		restaurant.setName("Sagar Ratna 2");
		restaurant.setRating(4);
		System.out.println("Saving restaurant to Database");

		entityManager.persist(restaurant);
		// I have reached the managed state

		entityManager.detach(restaurant);
		// change the state to detach state

		entityManager.merge(restaurant);

		restaurant.setPincode(1223);
		// still managed state
		// Managed
		entityManager.getTransaction().commit();
		System.out.println("Generated restaurant ID = " + restaurant.getId());

		// get an object using primary key.
		Restaurants res = entityManager.find(Restaurants.class, restaurant.getId());
		System.out.println("Got object " + res.getName() + " " + res.getId());

		// get all the objects from restaurant table
		@SuppressWarnings("unchecked")
		Query listResult = entityManager.createQuery("SELECT e FROM Restaurants e");
		List<Restaurants> listRes = listResult.getResultList();

		if (listRes == null) {
			System.out.println("No Restaurant found . ");
		} else {
			for (Restaurants r :  listRes) {
				System.out.println("Restaurants name= " + r.getName() + ", Restaurant id " + r.getId());
			}
		}
		// remove and entity
		entityManager.getTransaction().begin();
		System.out.println("Deleting Restaurant with ID = " + res.getId());
		entityManager.remove(res);
		entityManager.getTransaction().commit();

		// close the entity manager
		entityManager.close();
		entityManagerFactory.close();

	}



}


