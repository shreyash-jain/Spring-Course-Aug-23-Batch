package com.shreyash.demo.Features.UrlShortner.Service;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LivingBeingInvocationHandler implements InvocationHandler {

    private Animal animal;

    public LivingBeingInvocationHandler(Animal animal) {
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Birth");
        method.invoke(animal, args);
        System.out.println("Death");
        return true;
    }
}

