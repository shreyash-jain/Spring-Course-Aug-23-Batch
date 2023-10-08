package com.shreyash.demo;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Book extends MyProduct {
    private String author;
}