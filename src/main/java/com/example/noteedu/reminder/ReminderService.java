package com.example.noteedu.reminder;

import com.example.noteedu.tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ReminderService {

    private final ReminderRepository reminderRepository;
    private final TagRepository tagRepository;

    @Autowired
    public ReminderService(ReminderRepository reminderRepository, TagRepository tagRepository) {
        this.reminderRepository = reminderRepository;
        this.tagRepository = tagRepository;
    }

    public List<Reminder> getReminders() {
        return reminderRepository.findAll();
    }

    public Reminder createReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    @Transactional
    public void updateReminder(Reminder newReminder) {
        Reminder reminder = reminderRepository.findById(newReminder.getId()).orElseThrow(() -> new IllegalStateException("reminder with id "+ newReminder.getId() + " does not exist"));

        if (newReminder.getTitle() != null && newReminder.getTitle().length() > 0 && !Objects.equals(reminder.getTitle(), newReminder.getTitle())){
            reminder.setTitle(newReminder.getTitle());
        }

        if (newReminder.getDescription() != null && newReminder.getDescription().length() > 0 && !Objects.equals(reminder.getDescription(), newReminder.getDescription())){
            reminder.setDescription(newReminder.getDescription());
        }
    }

    public void deleteReminder(Long id) {
        Reminder reminder = reminderRepository.findById(id).orElseThrow(() -> new IllegalStateException("reminder with id "+ id + " does not exist"));

        reminderRepository.delete(reminder);
    }
}
