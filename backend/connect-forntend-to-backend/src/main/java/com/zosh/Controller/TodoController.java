package com.zosh.Controller;


import com.zosh.Service.TodoService;
import com.zosh.model.ApiResponse;
import com.zosh.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/api")
    public ApiResponse homeController(){
        ApiResponse res = new ApiResponse();
        res.setMessage("Welcome to todo API.");
        res.setStatus(true);
        return res;
    }

    @GetMapping("/api/todos")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @PostMapping("/api/todos")
    public Todo createTodos(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }

    @DeleteMapping("/api/todos/{id}")
    public ApiResponse deleteTodos(@PathVariable Long id) throws Exception {
        todoService.deleteTodo(id);
        ApiResponse res = new ApiResponse();
        res.setMessage("todo deleted Successfully.");
        res.setStatus(true);
        return res;
    }

}
