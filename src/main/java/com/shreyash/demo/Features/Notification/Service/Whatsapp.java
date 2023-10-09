package com.shreyash.demo.Features.Notification.Service;


import com.shreyash.demo.Core.Configuration.WhatsappConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Whatsapp implements MessageService {

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
