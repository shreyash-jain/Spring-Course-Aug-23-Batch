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

		//persistData();

		persistWithHibernate();
	}

//	public void persistWithJPA(){
//		// JPA - Hibernate
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
//		// Persistence Context
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		//
//
//		System.out.println("Starting Transaction");
//		entityManager.getTransaction().begin();
//		Restaurants restaurant = new Restaurants();
//		// New - Transcient
//
//		restaurant.setName("Sagar Ratna 2");
//		restaurant.setRating(4);
//		System.out.println("Saving restaurant to Database");
//
//		entityManager.persist(restaurant);
//		// I have reached the managed state
//
//		entityManager.detach(restaurant);
//		// change the state to detach state
//
//		entityManager.merge(restaurant);
//
//		restaurant.setPincode(1223);
//		// still managed state
//		// Managed
//		entityManager.getTransaction().commit();
//		System.out.println("Generated restaurant ID = " + restaurant.getId());
//
//		// get an object using primary key.
//		Restaurants res = entityManager.find(Restaurants.class, restaurant.getId());
//		System.out.println("Got object " + res.getName() + " " + res.getId());
//
//		// get all the objects from restaurant table
//		@SuppressWarnings("unchecked")
//		Query listResult = entityManager.createQuery("SELECT e FROM Restaurants e");
//		List<Restaurants> listRes = listResult.getResultList();
//
//		if (listRes == null) {
//			System.out.println("No Restaurant found . ");
//		} else {
//			for (Restaurants r :  listRes) {
//				System.out.println("Restaurants name= " + r.getName() + ", Employee id " + r.getId());
//			}
//		}
//		// remove and entity
//		entityManager.getTransaction().begin();
//		System.out.println("Deleting Restaurant with ID = " + res.getId());
//		entityManager.remove(res);
//		entityManager.getTransaction().commit();
//
//		// close the entity manager
//		entityManager.close();
//		entityManagerFactory.close();
//
//	}

	// Application
	// JPA -> JPA, Native Hibernate -> ORM -> EntityManager -> Repositories
	// <XML File> -> my map -> objects -> tables
	// Hibernate Layer -> Session Factory -> Query, Txn
	// JDBC Layer - Multiple Drivers
	// Driver
	// DB


	// jdbc, jpa, hibernate, spring jdbc, spring jpa

	// ACID - txns
	// Objects -> Relational DBs

	// Person -> Name, email, Address
	// Address

	public void persistWithHibernate(){

		// Entity Manager : JPA
		// Session : Hibernate

		// Entity Manager Factory : JPA
		// Session Factory : Hibernate

		Session session = sessionFactory.openSession();
		System.out.println("Starting Transaction");
		session.getTransaction().begin();
		Restaurants restaurant = new Restaurants();
		restaurant.setName("Bakery Plus");
		restaurant.setRating(4);
		System.out.println("Saving restaurant to Database");

		session.persist(restaurant);
		session.getTransaction().commit();
		System.out.println("Generated restaurant ID = " + restaurant.getId());

		// get an object using primary key.
		Restaurants res = session.find(Restaurants.class, restaurant.getId());
		System.out.println("got object " + res.getName() + " " + res.getId());

		// get all the objects from restaurant table
		@SuppressWarnings("unchecked")
		List<Restaurants> listRes = session.createQuery("SELECT e FROM Restaurants e").getResultList();

		if (listRes == null) {
			System.out.println("No Restaurant found . ");
		} else {
			for (Restaurants r :  listRes) {
				System.out.println("Restaurants name= " + r.getName() + ", Employee id " + r.getId());
			}
		}
		// remove and entity
		session.getTransaction().begin();
		System.out.println("Deleting Restaurant with ID = " + res.getId());
		session.remove(res);
		session.getTransaction().commit();

		// close the entity manager
		session.close();
		session.close();

	}


	public void persistData() {

		try {

			java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy", "foo", "bar");

			PreparedStatement stmt = connection.prepareStatement("INSERT INTO PUBLISHER (CODE, PUBLISHER_NAME) VALUES (?, ?)");
			stmt.setString(1, "4");
			stmt.setString(2,"2");
			stmt.executeUpdate();

			stmt.close();

			stmt = connection.prepareStatement("INSERT INTO PUBLISHER (ISBN, BOOK_NAME, PUBLISHER_CODE) VALUES (?, ?, ?)");
			stmt.setString(1,"5");
			stmt.setString(2, "2");
			stmt.setString(3, "3");
			stmt.executeUpdate();

			// connection pool

			//Todo t = Todo.builder().build();
			//t.getResource();

			stmt.close();

		}
		catch (SQLException e) { e.printStackTrace(); } finally { try { connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	}


}


