package com.shreyash.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Notification {

    @Autowired
    MessageService messageService;

    Notification(){
        System.out.println("Helllo");
    }

    void sendMessage(String message){
        messageService.sendMessage(message);
    }

}
