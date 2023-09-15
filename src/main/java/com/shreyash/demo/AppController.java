package com.shreyash.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;

@Controller
public class AppController {

    @Autowired
    WhatsappConfig hostName;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    public WhatsappConfig getBook(@PathVariable int id) {
        return hostName;
    }
}
