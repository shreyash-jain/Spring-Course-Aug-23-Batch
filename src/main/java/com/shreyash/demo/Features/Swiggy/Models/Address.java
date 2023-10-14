package com.shreyash.demo.Features.Swiggy.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Address")
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name = "pincode")
    public String pincode;
    @Column(name = "city")
    public String city;
    @OneToOne(mappedBy = "address_temp")
    public Restaurants restaurant;

    public Address(String pincode, String city) {
        this.pincode = pincode;
        this.city = city;
    }
}
