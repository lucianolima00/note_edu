package com.example.noteedu.reminder;

import com.example.noteedu.note.Note;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Reminder extends Note {
    @Id
    @SequenceGenerator(
            name = "reminder_sequence",
            sequenceName = "reminder_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reminder_sequence"
    )
    private long tagId;
    private LocalDate dueDate;

    public Reminder(String title, String description, LocalDate dueDate) {
        super(title, description);
        this.dueDate = dueDate;
    }

    public Reminder(long id, String title, String description, LocalDate dueDate) {
        super(id, title, description);
        this.dueDate = dueDate;
    }

    public Reminder() {
        super();
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
