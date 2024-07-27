package com.zosh.Service;

import com.zosh.model.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> getAllTodos();

    Todo createTodo(Todo todo);

    void deleteTodo( Long id) throws Exception;

}

