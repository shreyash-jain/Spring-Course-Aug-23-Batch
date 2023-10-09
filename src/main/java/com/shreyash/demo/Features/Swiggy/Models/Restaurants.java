package com.shreyash.demo.Features.Swiggy.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
    @Column(name = "pincode")
    public String pincode;
    @Column(name = "cuisine")
    public String cuisine;
    @Column(name = "rating")
    public Integer rating;

    public Restaurants(String name, String pincode, String cuisine) {
        this.name = name;
        this.pincode = pincode;
        this.cuisine = cuisine;
    }
}
