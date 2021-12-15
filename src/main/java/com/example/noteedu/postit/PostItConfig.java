package com.example.noteedu.postit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class PostItConfig {

    @Bean
    CommandLineRunner postItCommandLine(PostItRepository repository) {
        return args -> {
            PostIt postIt = new PostIt(
                    "Test",
                    "Test",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            repository.save(postIt);
        };
    }
}
