package com.shreyash.demo.Features.Swiggy.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Resturants")
@NoArgsConstructor
public class Restaurants {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name = "name")
    public String name;
    @Column(name = "cuisine")
    public String cuisine;
    @Column(name = "rating")
    public Integer rating;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    public Address address_temp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurants")
    public List<FoodItem> foodItems;



    // parent -> saving the restaurant

    // one to one and many to one -> Eagerly
    // many to many to one to many -> Lazy


    public Restaurants(String name, Address address, String cuisine) {
        this.name = name;
        this.address_temp = address;
        this.cuisine = cuisine;
    }
}


// restaurant - 1,2,3
// fooditems - 8,9,10
// r_f = 1_8, 1_9, 2_10
// id
// address_id


// how the cmds are passing from owner to inverse entity

// Persit the owner -> CascadeType.Persist
// Updating the owner -> CascadeType.Merge
// delete the owner -> CascadeType.Remove
// All -> Cascade.ALL


