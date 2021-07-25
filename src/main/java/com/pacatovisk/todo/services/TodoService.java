package com.pacatovisk.todo.services;

import com.pacatovisk.todo.domain.Todo;
import com.pacatovisk.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo findById(Integer id) {
       Optional<Todo> obj =  todoRepository.findById(id);
       return obj.orElse(null);
    }

    public List<Todo> findAllOpen() {
        List<Todo> list = todoRepository.findAllOpen();
        return list;
    }

    public List<Todo> findAllClosed(){
        List<Todo> list = todoRepository.findAllClosed();
        return list;
    }

    public List<Todo> findAll(){
        List<Todo> list = todoRepository.findAll();
        return list;
    }

    public Todo create(Todo obj) {
        return todoRepository.save(obj);
    }
}
