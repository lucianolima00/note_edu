package com.example.noteedu.notebook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotebookConfig {

    @Bean
    CommandLineRunner notebookCommandLine(NotebookRepository repository) {
        return args -> {
            Notebook notebook = new Notebook(
                    "Test",
                    "00ECE1"
            );

            repository.save(notebook);
        };
    }
}
