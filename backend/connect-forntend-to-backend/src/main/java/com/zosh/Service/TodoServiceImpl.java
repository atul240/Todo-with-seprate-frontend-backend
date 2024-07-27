package com.zosh.Service;

import com.zosh.Repository.TodoRepository;
import com.zosh.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos() {
        return  todoRepository.findAll();
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long id) throws Exception{
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new Exception("todo not found"));
        todoRepository.delete(todo);
    }
}
