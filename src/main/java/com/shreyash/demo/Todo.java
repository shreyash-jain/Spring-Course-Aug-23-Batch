package com.shreyash.demo;

public class Todo {
    public Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String name;

    public Todo() {

    }

    public Todo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
