package com.shreyash.demo;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Optional;

@RestController
public class AppController {


    @Autowired
    WhatsappConfig whatsappConfig;
    //www.google.com/hello/7/again?ad_source=facebook

    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    public WhatsappConfig getBook(@PathVariable int id, @RequestParam(value = "num") Optional<Integer> num) {

            System.out.println(num);
            throw new RuntimeException("My Error");
            //return whatsappConfig;

    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorInfo handleException(HttpServletRequest req, Exception ex) {
       return new ErrorInfo(req.getRequestURL().toString(), ex);
    }


    class ErrorInfo {
        public final String url;
        public final String ex;

        public ErrorInfo(String url, Exception ex) {
            this.url = url;
            this.ex = ex.getLocalizedMessage();
        }


}

}


// Make Todo App
// Add a todo
// Delete a specific todo
// Update a specific todo
// Get all todos
// Get a specific todo
