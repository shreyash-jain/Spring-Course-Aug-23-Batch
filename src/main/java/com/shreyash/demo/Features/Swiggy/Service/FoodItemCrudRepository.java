package com.shreyash.demo.Features.Swiggy.Service;

import com.shreyash.demo.Features.Swiggy.Models.FoodItem;
import com.shreyash.demo.Features.Swiggy.Models.Restaurants;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemCrudRepository extends CrudRepository<FoodItem, Integer> {
}
