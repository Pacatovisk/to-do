package com.pacatovisk.todo.resources;

import com.pacatovisk.todo.domain.Todo;
import com.pacatovisk.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/todos")
public class TodoResource {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Integer id) {
        Todo obj = todoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/open")
    public ResponseEntity<List<Todo>> listAllOpen() {
        List<Todo> listOpen = todoService.findAllOpen();
        return ResponseEntity.ok().body(listOpen);
    }

    @GetMapping(value = "/closed")
    public ResponseEntity<List<Todo>> listAllClosed() {
        List<Todo> listClosed = todoService.findAllClosed();
        return ResponseEntity.ok().body(listClosed);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> listAll() {
        List<Todo> listAll = todoService.findAll();
        return ResponseEntity.ok().body(listAll);
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo obj) {
        obj = todoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
