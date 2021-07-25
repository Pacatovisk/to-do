package com.pacatovisk.todo.services;

import com.pacatovisk.todo.domain.Todo;
import com.pacatovisk.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TodoRepository todoRepository;

    public void instaciaBaseDeDados(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Todo t1 = new Todo(null, "Estudar", "Estudar SpringBoot 2 e Angular 12", LocalDateTime.parse("25/03/2022 10:40", formatter), true);
        Todo t2 = new Todo(null, "Meditar", "Meditar no quarto com som de cachoeira", LocalDateTime.parse("25/03/2022 20:40", formatter), false);
        Todo t3 = new Todo(null, "Correr", "Correr 3km na praça", LocalDateTime.parse("25/03/2022 08:00", formatter), true);
        Todo t4 = new Todo(null, "Almoçar", "Comer arroz e feijão", LocalDateTime.parse("25/03/2022 12:00", formatter), false);
        Todo t5 = new Todo(null, "Ler", "Ler o livro o Poder do Hábito", LocalDateTime.parse("25/03/2022 22:30", formatter), false);

        todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
    }
}
