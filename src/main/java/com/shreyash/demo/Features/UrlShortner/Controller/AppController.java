package com.shreyash.demo.Features.UrlShortner.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.shreyash.demo.Core.Configuration.WhatsappConfig;
import com.shreyash.demo.Core.Utils.JwtUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("app")
public class AppController {

    // Annotations, Object Mapper


    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    WhatsappConfig whatsappConfig;
    //www.google.com/hello/7/again?ad_source=facebook


    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    public WhatsappConfig getBook(@PathVariable int id, @RequestParam(value = "num") Optional<Integer> num) {

            System.out.println(num);



            return whatsappConfig;

    }

    @RequestMapping(method = RequestMethod.POST, path = "/create", produces = "application/json")
    public ResponseEntity<String> postSample(@RequestBody Map<String, String> body, @RequestAttribute boolean valid, @RequestHeader Map<String, String> headers) {
        System.out.println(headers.toString());
        System.out.println(body.toString());
        System.out.println(JwtUtil.generateToken(body.get("hello")));

        return ResponseEntity.ok().body("");
    }


    @RequestMapping(method = RequestMethod.POST, path = "/validate", produces = "application/json")
    public ResponseEntity<String> createSample(@RequestBody Map<String, String> body) {

        System.out.println(body.toString());
        System.out.println(JwtUtil.extractUsername(body.get("hello")));

        return ResponseEntity.ok().body("");
    }




}


// Make Todo App
// Add a todo
// Delete a specific todo
// Update a specific todo
// Get all todos
// Get a specific todo
