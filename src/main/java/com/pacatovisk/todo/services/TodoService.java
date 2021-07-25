package com.pacatovisk.todo.services;

import com.pacatovisk.todo.domain.Todo;
import com.pacatovisk.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo findById(Integer id) {
       Optional<Todo> obj =  todoRepository.findById(id);
       return obj.orElse(null);
    }
}
