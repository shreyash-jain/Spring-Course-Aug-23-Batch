package com.shreyash.demo.Core.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
public class MyProduct {
    @Id
    private long productId;
    private String name;

    // constructor, getters, setters
}