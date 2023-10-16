package com.shreyash.demo.Features.UrlShortner.Service;

public class Dog implements Animal{
    @Override
    public void introduce(String name) {
        System.out.println("My name is " + name);

    }

    @Override
    public void sayAge(int age) {
        System.out.println("My age is " + age);

    }
}
