package com.shreyash.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TodoController {


    @Autowired
    TodoService todoService;
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("alltodolist", todoService.getAllTodo());
        System.out.println("Seck");
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewTodo(Model model) {
        Todo todo = new Todo();
        model.addAttribute("todo", todo);
        return "newtodo";
    }

    @GetMapping("/showUpdate/{id}")
    public String getUpdatePage(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("todo", todoService.getById(id));
        return "update";
    }
    @GetMapping("/deleteTodo/{id}")
    public String deleteTodo(@PathVariable(value = "id") int id, Model model) {
        todoService.deleteById(id);
        return "redirect:/";
    }

}


// todo class
// interface ->
// impl
// controller

