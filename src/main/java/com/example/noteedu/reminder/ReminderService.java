package com.example.noteedu.reminder;

import com.example.noteedu.tag.Tag;
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
    public void updateReminder(Long id, String title, String description, Long tagId) {
        Reminder reminder = reminderRepository.findById(id).orElseThrow(() -> new IllegalStateException("reminder with id "+ id + " does not exist"));
        Tag tag = tagRepository.findById(tagId).orElseThrow(() -> new IllegalStateException("tag with id "+ id + " does not exist"));

        if (title != null && title.length() > 0 && !Objects.equals(reminder.getTitle(), title)) {
            reminder.setTitle(title);
        }

        if (description != null && description.length() > 0 && !Objects.equals(reminder.getDescription(), description)) {
            reminder.setDescription(description);
        }

        if (tag != null && !Objects.equals(reminder.getTag(), tag)) {
            reminder.setTag(tag);
        }
    }

    public void deleteReminder(Long id) {
        Reminder reminder = reminderRepository.findById(id).orElseThrow(() -> new IllegalStateException("reminder with id "+ id + " does not exist"));

        reminderRepository.delete(reminder);
    }
}
