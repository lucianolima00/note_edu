package com.example.noteedu.reminder;

import com.example.noteedu.note.Note;
import com.example.noteedu.tag.Tag;
import com.example.noteedu.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reminder extends Note {
    private LocalDate dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public Reminder(String title, String description, Boolean finished, LocalDate dueDate) {
        super(title, description, finished);
        this.dueDate = dueDate;
    }

    public Reminder(String title, String description, Boolean finished, LocalDate dueDate, Tag tag) {
        super(title, description, finished);
        this.dueDate = dueDate;
        this.tag = tag;
    }

    public Reminder(long id, String title, String description, Boolean finished, LocalDate dueDate, Tag tag, User user) {
        super(id, title, description, finished, user);
        this.dueDate = dueDate;
        this.tag = tag;
    }

    public Reminder() {
        super();
    }

    @Override
    public void execute() {
        Tag tag = new Tag("Finished", "#FFFFFF");
        this.setTag(tag);
        this.setFinished(true);
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Reminder: {" +
                "id=" + super.getId() +
                ", title='" + super.getTitle() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", due_date='" + dueDate + '\'' +
                ", tag='" + tag.toString() + '\'' +
                ", user='" + super.getUser().toString() + '\'' +
                "}";
    }
}
