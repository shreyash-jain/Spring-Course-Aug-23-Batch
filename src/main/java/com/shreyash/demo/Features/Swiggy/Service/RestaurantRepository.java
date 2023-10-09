package com.shreyash.demo.Features.Swiggy.Service;


import com.shreyash.demo.Features.Swiggy.Models.Restaurants;
import org.hibernate.Session;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class RestaurantRepository {
//    private Session session;
//
//    public RestaurantRepository(Session session) {
//        this.session = session;
//    }
//
//    public Optional<Restaurants> save(Restaurants restaurants) {
//        try {
//            session.getTransaction().begin();
//            if (Objects.isNull(restaurants.getId())) session.persist(restaurants);
//            else session.merge(restaurants);
//
//            session.getTransaction().commit();
//            return Optional.of(restaurants);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }
//
//    public Optional<Restaurants> findById(Integer id){
//        Restaurants res = session.find(Restaurants.class, id);
//        return res!=null?Optional.of(res) : Optional.empty();
//    }
//
//    public List<Restaurants> findAll() {
//        return session.createQuery("select r from Restaurants r").getResultList();
//    }

}
