package com.shreyash.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("alltodolist", null);
        return "index";
    }
    @GetMapping("/update")
    public String viewUpdatePage(Model model) {
        //model.addAttribute("alltodolist", null);
        return "update";
    }
    @GetMapping("/newtodo")
    public String viewNewTodoPage(Model model) {
        //model.addAttribute("alltodolist", null);
        return "newtodo";
    }

}


// todo class
// interface ->
// impl
// controller

