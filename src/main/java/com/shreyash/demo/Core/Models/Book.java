package com.shreyash.demo.Core.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Book extends MyProduct {
    private String author;
}