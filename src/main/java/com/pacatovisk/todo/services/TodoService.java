package com.pacatovisk.todo.services;

import com.pacatovisk.todo.domain.Todo;
import com.pacatovisk.todo.repositories.TodoRepository;
import com.pacatovisk.todo.services.exceptions.ObjectNotFoundException;
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
       return obj.orElseThrow(() ->
               new ObjectNotFoundException("Objeto não encontrado! " +
                       "Id: " + id + ", Tipo: " + Todo.class.getName()));
    }

    public List<Todo> findAllOpen() {
        return todoRepository.findAllOpen();
    }

    public List<Todo> findAllClosed(){
        return todoRepository.findAllClosed();
    }

    public List<Todo> findAll(){
        return todoRepository.findAll();
    }

    public Todo create(Todo obj) {
        return todoRepository.save(obj);
    }

    public void delete(Integer id) {
        todoRepository.deleteById(id);
    }

    public Todo update(Integer id, Todo obj) {
        Todo newObj = findById(id);
        newObj.setTitulo(obj.getTitulo());
        newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
        newObj.setDescricao(obj.getDescricao());
        newObj.setFinalizado(obj.getFinalizado());
        return todoRepository.save(newObj);
    }
}
