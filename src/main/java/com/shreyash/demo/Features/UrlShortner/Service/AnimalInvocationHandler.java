package com.shreyash.demo.Features.UrlShortner.Service;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AnimalInvocationHandler implements InvocationHandler {

    private Animal animal;

    public AnimalInvocationHandler(Animal animal) {
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("Hi!");
        method.invoke(animal, args);
        System.out.println("Bye");
        return true;
    }
}

