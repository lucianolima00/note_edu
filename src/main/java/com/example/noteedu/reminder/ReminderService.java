package com.example.noteedu.reminder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ReminderService {

    private final ReminderRepository reminderRepository;

    @Autowired
    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    public List<Reminder> getReminders() {
        return reminderRepository.findAll();
    }

    public Reminder createReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    @Transactional
    public void updateReminder(Long id, String title, String description) {
        Reminder reminder = reminderRepository.findById(id).orElseThrow(() -> new IllegalStateException("reminder with id "+ id + " does not exist"));

        if (title != null && title.length() > 0 && !Objects.equals(reminder.getTitle(), title)){
            reminder.setTitle(title);
        }

        if (description != null && description.length() > 0 && !Objects.equals(reminder.getDescription(), description)){
            reminder.setDescription(description);
        }
    }

    public void deleteReminder(Long id) {
        Reminder reminder = reminderRepository.findById(id).orElseThrow(() -> new IllegalStateException("reminder with id "+ id + " does not exist"));

        reminderRepository.delete(reminder);
    }
}
