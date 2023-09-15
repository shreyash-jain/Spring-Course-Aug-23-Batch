package com.shreyash.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Notification {



    public void setThisService( ) {

    }

    @Autowired
    MessageService thisService;



    void sendMessage(String message){
        thisService.sendMessage(message);
    }


}
