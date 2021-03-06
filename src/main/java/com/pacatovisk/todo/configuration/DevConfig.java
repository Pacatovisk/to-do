package com.pacatovisk.todo.configuration;

import com.pacatovisk.todo.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService  dbService;

    @Bean
    public boolean instancia(){
        this.dbService.instaciaBaseDeDados();
        return true;
    }
}
