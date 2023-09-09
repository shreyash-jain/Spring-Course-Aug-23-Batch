package com.shreyash.demo;
import org.springframework.stereotype.Component;

@Component
public interface MessageService {
    void sendMessage(String message);
}
