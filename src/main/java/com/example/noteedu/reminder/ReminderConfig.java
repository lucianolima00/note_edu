package com.example.noteedu.reminder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class ReminderConfig {

    @Bean
    CommandLineRunner reminderCommandLine(ReminderRepository repository) {
        return args -> {
            Reminder reminder = new Reminder(
                    "Test",
                    "Test",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            repository.save(reminder);
        };
    }
}
