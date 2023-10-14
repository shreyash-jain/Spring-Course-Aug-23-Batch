package com.shreyash.demo.Features.Swiggy.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "FoodItem")
@NoArgsConstructor
@Getter
@Setter
public class FoodItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name = "name")
    public String name;
    @Column(name = "cuisine")
    public String cuisine;
    @ManyToMany(mappedBy = "foodItems")
    @JoinColumn(name = "address_id", referencedColumnName = "id")

    public List<Restaurants> restaurants;


    public FoodItem(String name, String cuisine) {
        this.name = name;
        this.cuisine = cuisine;
    }
}


// fooditem_resturant