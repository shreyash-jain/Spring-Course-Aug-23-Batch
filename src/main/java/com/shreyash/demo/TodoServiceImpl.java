package com.shreyash.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class TodoServiceImpl implements TodoService{

    ArrayList<Todo> myTodos = new ArrayList<>(){
        {
           // add(new Todo(1, "Bring Milk"));
        }
    };
    @Override
    public List<Todo> getAllTodo() {
        return myTodos;
    }

    @Override
    public void save(Todo todo) {
        if(Objects.isNull(todo)) throw new RuntimeException();
        if(Objects.isNull(todo.id)) {
            todo.setId(myTodos.size()+1);
            myTodos.add(todo);
            return;
        }

        Optional<Todo> thisTodo = myTodos.stream().filter((t)-> Objects.equals(t.id, todo.getId())).findFirst();
        if(thisTodo.isEmpty()) throw new RuntimeException();

        thisTodo.get().setName(todo.getName());

    }

    @Override
    public Todo getById(Integer id) {
        Optional<Todo> thisTodo = myTodos.stream().filter((t)-> Objects.equals(t.id, id)).findFirst();
        if(thisTodo.isEmpty()) throw new RuntimeException();
        return thisTodo.get();
    }

    @Override
    public void deleteById(Integer id) {
        myTodos.remove(getById(id));
    }
}
