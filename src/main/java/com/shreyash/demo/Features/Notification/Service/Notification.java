package com.shreyash.demo.Features.Notification.Service;

import com.shreyash.demo.Features.Notification.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
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
