package com.example.noteedu.reminder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reminder")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReminderController {

    private final ReminderService reminderService;

    @Autowired
    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping
    public List<Reminder> index() {
        return reminderService.getReminders();
    }

    @PostMapping
    public Reminder create(@RequestBody Reminder reminder) {
        return reminderService.createReminder(reminder);
    }

    @PutMapping(path = "{reminderId}")
    public void update(
            @PathVariable("reminderId") Long id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Long tagId) {
        reminderService.updateReminder(id,title, description, tagId);
    }

    @PostMapping(path = "{reminderId}")
    public void delete(@PathVariable("reminderId") Long id) {
        reminderService.deleteReminder(id);
    }
}
