package com.shreyash.demo.Features.UrlShortner.Controller;


import com.shreyash.demo.Core.Configuration.WhatsappConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("app")
public class AppController {


    @Autowired
    WhatsappConfig whatsappConfig;
    //www.google.com/hello/7/again?ad_source=facebook

    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    public WhatsappConfig getBook(@PathVariable int id, @RequestParam(value = "num") Optional<Integer> num) {

            System.out.println(num);
            throw new RuntimeException("Some error");

    }




}


// Make Todo App
// Add a todo
// Delete a specific todo
// Update a specific todo
// Get all todos
// Get a specific todo
