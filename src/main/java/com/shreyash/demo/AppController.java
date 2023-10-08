package com.shreyash.demo;


import org.springframework.beans.factory.annotation.Autowired;
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
            return whatsappConfig;
    }


    // localhost:8080/post/56

    // mobiles, laptops


    @RequestMapping(method = RequestMethod.POST, path = "/post/{id}", produces = "application/json")
    public WhatsappConfig addBook(@PathVariable int id, @RequestParam(value = "num") Optional<Integer> num) {

        // doing a clean up job
        return whatsappConfig;
    }


}


// Make Todo App
// Add a todo
// Delete a specific todo
// Update a specific todo
// Get all todos
// Get a specific todo
