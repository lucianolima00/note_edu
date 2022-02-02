package com.example.noteedu.tag;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TagConfig {

    @Bean
    CommandLineRunner tagCommandLine(TagRepository repository) {
        return args -> {
            Tag tag = new Tag(
                    "Test",
                    "00ECE1"
            );

            repository.save(tag);
        };
    }
}
