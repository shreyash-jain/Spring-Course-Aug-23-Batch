package com.shreyash.demo.Features.Notification.Service;
import org.springframework.stereotype.Component;

@Component
public interface MessageService {
    void sendMessage(String message);

    class Sms implements MessageService {

        Sms(){
            System.out.println("Cello");
        }
        @Override
        public void sendMessage(String message) {
            System.out.println(message);

        }
    }
}
