package com.shreyash.demo;


import org.springframework.stereotype.Component;

@Component
public class Whatsapp implements MessageService{

    Whatsapp(){
        System.out.println("Cello");
    }
    @Override
    public void sendMessage(String message) {
        System.out.println(message);

    }
}
