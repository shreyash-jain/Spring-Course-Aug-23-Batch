package com.shreyash.demo.Core.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Pen extends MyProduct {
    private String color;
}