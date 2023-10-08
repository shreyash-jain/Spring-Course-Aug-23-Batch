package com.shreyash.demo;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Column(name = "address_line", unique = true)
    String addressLine;
    @Column(name = "city", unique = true)
    String city;
    @Column(name = "pincode", unique = true)
    String pinCode;
}
