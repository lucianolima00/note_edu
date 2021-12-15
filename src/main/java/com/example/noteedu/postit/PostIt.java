package com.example.noteedu.postit;

import com.example.noteedu.note.Note;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PostIt extends Note {
    private LocalDate dueDate;

    public PostIt(String title, String description, LocalDate dueDate) {
        super(title, description);
        this.dueDate = dueDate;
    }

    public PostIt(long id, String title, String description, LocalDate dueDate) {
        super(id, title, description);
        this.dueDate = dueDate;
    }

    public PostIt() {
        super();
    }
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
