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



    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println(audience);

        Notification n = applicationContext.getBean(Notification.class);
        n.sendMessage("Hello");
        doRepoOps();

    }

    private void doRepoOps(){
        RestaurantRepository restaurantRepository = new RestaurantRepository(sessionFactory.openSession());
        Location hLoc = new Location("Saket", "New Delhi", "110017");
        Restaurants haldirams = new Restaurants("Haldiram", hLoc, "Indian");
        AccountDetails accountDetails = new AccountDetails("a@g.com", "qr_code");
        haldirams.setAccount(accountDetails);
        restaurantRepository.save(haldirams);

        Location bLoc = new Location("Saket", "New Delhi", "110017");
        Restaurants bikarnerwala = new Restaurants("Bikanerwala", bLoc, "Indian");
        restaurantRepository.save(bikarnerwala);

        restaurantRepository.findAll().stream().forEach((r) -> {
            System.out.println(r.getName());
        });

    }




}


