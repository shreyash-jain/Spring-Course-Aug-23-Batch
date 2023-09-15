package com.shreyash.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class Whatsapp implements MessageService{

    @Autowired
    private WhatsappConfig whatsappConfig;


    Whatsapp(){
        System.out.println("Cello");
    }
    @Override
    public void sendMessage(String message) {
        System.out.println(whatsappConfig.getHostName().getCompanyName() + " : " + message);

    }
}
