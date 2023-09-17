package com.shreyash.demo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodo();
    void save(Todo todo);
    Todo getById(Integer id);
    void deleteById(Integer id);

}
