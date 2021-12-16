package com.example.noteedu.postit;

import com.example.noteedu.note.Note;
import com.example.noteedu.user.User;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PostIt extends Note {
    private LocalDate dueDate;

    public PostIt(String title, String description, Boolean finished, LocalDate dueDate) {
        super(title, description, finished);
        this.dueDate = dueDate;
    }

    public PostIt(long id, String title, String description, Boolean finished, LocalDate dueDate, User user) {
        super(id, title, description, finished, user);
        this.dueDate = dueDate;
    }

    public PostIt() {
        super();
    }

    @Override
    public void execute() {
        try {
            this.setFinished(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "PostIt: {" +
                "id=" + super.getId() +
                ", title='" + super.getTitle() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", due_date='" + dueDate + '\'' +
                ", user='" + super.getUser().toString() + '\'' +
                "}";
    }
}
