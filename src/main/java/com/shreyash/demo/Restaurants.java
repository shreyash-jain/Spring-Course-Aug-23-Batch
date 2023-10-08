package com.shreyash.demo;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "Resturants")
public class Restaurants {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "name")
    public String name;

    @Embedded
    @Column(name = "location")
    public Location location;

    @Column(name = "cuisine")
    public String cuisine;

    @Column(name = "rating")
    public Integer rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountDetails account;

    public Restaurants(String name, Location location, String cuisine) {
        this.name = name;
        this.location = location;
        this.cuisine = cuisine;
    }
}
