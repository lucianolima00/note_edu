package com.example.noteedu.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.example.noteedu.models.Reminder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReminderController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/reminder")
    public Reminder reminder(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Reminder();
    }
}
