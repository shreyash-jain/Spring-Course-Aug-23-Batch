package com.shreyash.demo;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



public class Sms implements MessageService{

    Sms(){
        System.out.println("Cello");
    }
    @Override
    public void sendMessage(String message) {
        System.out.println(message);

    }
}
