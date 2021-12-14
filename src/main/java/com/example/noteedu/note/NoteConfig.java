package com.example.noteedu.note;

import com.example.noteedu.note.Note;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class NoteConfig {

    @Bean
    CommandLineRunner commandLineRunner(NoteRepository repository) {
        return args -> {
            Note note = new Note(
                    "Test",
                    "Test"
            );

            repository.save(note);
        };
    }
}
