package com.shreyash.demo;

import com.shreyash.demo.Features.Swiggy.Models.Address;
import com.shreyash.demo.Features.Swiggy.Models.FoodItem;
import com.shreyash.demo.Features.Swiggy.Models.Restaurants;
import com.shreyash.demo.Features.Swiggy.Service.FoodItemCrudRepository;
import com.shreyash.demo.Features.Swiggy.Service.RestaurantCrudRepository;
import com.shreyash.demo.Features.Swiggy.Service.RestaurantRepository;
import com.shreyash.demo.Features.UrlShortner.Service.Animal;
import com.shreyash.demo.Features.UrlShortner.Service.AnimalInvocationHandler;
import com.shreyash.demo.Features.UrlShortner.Service.Dog;
import com.shreyash.demo.Features.UrlShortner.Service.LivingBeingInvocationHandler;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.lang.reflect.Proxy;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@PropertySource("classpath:new.properties")
@EnableScheduling
public class DemoApplication implements ApplicationRunner {

    @Value("${app.me}")
    private String audience;


    java.sql.Connection connection;

    @Autowired
    TransactionTemplate transactionTemplate;

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
        createProxy();
    }

    void createProxy() {
        Dog arnold = new Dog();

        // Get the class loader from the original object
        ClassLoader arnoldClassLoader = arnold.getClass().getClassLoader();

        // Get all the interfaces that the original object implements
        Class[] interfaces = arnold.getClass().getInterfaces();

        // Create a proxy for our arnold object
        Animal proxyArnold = (Animal) Proxy.newProxyInstance(arnoldClassLoader, interfaces, new AnimalInvocationHandler(arnold));


        // Call one of our original object's methods on the proxy object
        proxyArnold.introduce("arnold");
    }

    // crud operations : create, read, update and delete




    @Transactional(propagation = Propagation.REQUIRED)
    void doBefore() {
        doAfter();

    }


    void doBeforeNonTxn() {
        doAfter();
    }

    ;


    void doAfter() {
		// random stuff
        System.out.println("10");
    }

    ;


    void doTxn() {
        doBefore();
        persistWithHibernate();
        doAfter();
    }


    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.MANDATORY)
    public void persistWithHibernate() {

        // Entity Manager : JPA
        // Session : Hibernate

        // Entity Manager Factory : JPA
        // Session Factory : Hibernate

        Session session = sessionFactory.openSession();
        System.out.println("Starting Transaction");

        Address address = new Address("110017", "Delhi");
        Restaurants sagarRatna = new Restaurants("Sagar Ratna with food items", address, "South Indian");

        FoodItem pavBhaji = new FoodItem("Pav Bhaji", "Indian");
        pavBhaji.setRestaurants(sagarRatna);
        FoodItem burger = new FoodItem("Burger", "Indian");
		burger.setRestaurants(sagarRatna);
        List<FoodItem> foodItems = Arrays.asList(pavBhaji, burger);
        sagarRatna.setFoodItems(foodItems);

        restaurantCrudRepository.save(sagarRatna);

		// sagar ratna -> id
		// pav bhaji save -> id, restuarant_id

        Pageable restaurantPageable = Pageable.ofSize(50);

        Slice<Restaurants> these50Res = restaurantCrudRepository.getAllRestaurantsPaginated(restaurantPageable);
        while (these50Res.hasNext()) {

            these50Res = restaurantCrudRepository.getAllRestaurantsPaginated(these50Res.nextPageable());

        }
        // write the code to fetch all the data that is present in dd with getAllRestaurantsPaginated
        // Owner - the entity that should be changed -> Inverse End also changes
        // Inverse End - Address

        // address - owner
        // restaurant - inverse
        // address -> restaurant -> save the address

        session.close();
        session.close();

    }

    public Boolean hasDataEnded(Pageable pageable) {
        try {
            if (Objects.isNull(pageable)) {
                return true;
            }
        } catch (RuntimeException e) {
            return true;
        }
        return false;
    }

    // 1. check who is owner and who is inverse entity
    // 2. where to keep the foreign key
    // 3. the place where foreign key is not present -> mapped by

    // api = res_id, details of fooditem
    // query res having id ad res_id
    // fooditem -> new Fooditem()
    // fooditem.res_id = res_id


    // frontend -> jon to show the data in paginated
    // total pages = items/50
    // get the data on page 3
    // check if page 3 exists
    // restaurantPageable.withPage(3);


    // @Transactional

    // Transaction - ACID

    // Isolation
    // When your set of cmd that changes your database

    // set of cmd 1 - adding something to the account
    // set of cmd 2 - removing something to the account

    // knob - hide everything -
    // knob - tell everything - db will be more optimized

    // swiggy data

    // Dirty Reads

    // pav bhaji -> 10 -> 5
    // burger -> 20 -> 4

    // set of 1 ops began
    // select qnt*price from orders
    // 50, 80


    // set of 2 ops began
    // qnt = qnt + 5 for pav bhaji

    // set of 1 ops began
    // select sum(qnt*price) from orders
    // 155

    // 1 op is reading the uncommited updates for cmd2


    // Not - Repeatable Reads

    // pav bhaji -> 10 -> 5
    // burger -> 20 -> 4

    // set of 1 ops began
    // select qnt*price from orders
    // 50, 80


    // set of 2 ops began
    // qnt = qnt + 5 for pav bhaji
    // commit
    // pav bhaji -> 15 -> 5
    // burger -> 20 -> 4

    // set of 1 ops began
    // select sum(qnt*price) from orders
    // 155

    // Not - Repeatable Reads


    // pav bhaji -> 10 -> 5
    // burger -> 20 -> 4


    // set of 1 ops began
    // select qnt*price from orders
    // 50, 80


    // set of 2 ops began
    // insert pizza
    // commit
    // pav bhaji -> 15 -> 5
    // burger -> 20 -> 4
    // pizza -> 10 -> 10

    // set of 1 ops began
    // select sum(qnt*price) from orders
    // 75 + 80 + 100
    // 255

    // 1 op is reading the uncommited updates for cmd2


    // Isolation Levels

    // Read Uncommitted -> Dirty Reads, Lost Updates, Non - Repeatable reads, Phantom Reads - No Isolation
    // Read Committed -> Lost Updates, Non - Repeatable reads, Phantom Reads - All committed queries are shown
    // Repeatable Read -> Phantom Reads - all the cmds only see committed updates at the begining of other cmds those are committed
    // Serializable -> all the txns are serialized


    //


    // read a data from db
    // based on that data saving to db

    // payment

    // Hitachi -> icici, hdfc
    // message queue -> kafka -> producer
    // consumers -> adding data to db - mysql
    // transaction
	// proxy classes
	// testing
	// kafka - zookeeper
	// microservices
	// logging
	// Transactional
	// security - 6 hrs - 2 classes
	// catching - redis
	// AOP
	// Web Flux -> rest template
    // Deployment - AWS

	// Sat : 7:00 -> 9:30
	// Sun : 7:00 -> 9:30
	// Fri : 8:00 -> 10:00



}


// Swiggy provides you a software at your restaurant

// 200 Per month - usage charge, 500 per month - ad charge
// Lets say you started on October - 15th Oct 2022
// Take care of pro-rata charges
// At any point how many charges are pending - usage, ad
// At any point how much I have paid
// At a particular month How much I paid
// At any point I can pay at max of my pending charges


// pay usage charges -> 100 - at some date
// pay ad charges -> 300 - at some date

// charge table