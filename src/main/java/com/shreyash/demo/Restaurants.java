package com.shreyash.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Setter
@Getter
@Entity
@Table(name = "Resturants")
public class Restaurants {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name = "name")
    public String name;
    @Column(name = "pincode")
    public Integer pincode;
    @Column(name = "cuisine")
    public String cuisine;
    @Column(name = "rating")
    public Integer rating;

}
