package com.shreyash.demo;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;



public class RestaurantRepository {

    private Session session;

    public RestaurantRepository(Session session) {
        this.session = session;
    }


    public Optional<Restaurants> findById(Integer id) {
        Restaurants res = session.find(Restaurants.class, id);
        return res != null ? Optional.of(res) : Optional.empty();
    }

    public List<Restaurants> findAll() {
        return session.createQuery("select r from Restaurants r").getResultList();
    }

    public Optional<Restaurants> save(Restaurants restaurants) {
        try {
            session.getTransaction().begin();
            session.persist(restaurants);
            session.getTransaction().commit();
            return Optional.of(restaurants);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
