package com.example.noteedu.postit;

import com.example.noteedu.note.Note;
import com.example.noteedu.notebook.Notebook;
import com.example.noteedu.user.User;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PostIt extends Note {
    private LocalDate dueDate;
    private String color;

    public PostIt(String title, String description, Boolean finished, LocalDate dueDate, String color) {
        super(title, description, finished);
        this.dueDate = dueDate;
        this.color = color;
    }

    public PostIt(long id, String title, String description, Boolean finished, User user, Notebook notebook, LocalDate dueDate, String color) {
        super(id, title, description, finished, user, notebook);
        this.dueDate = dueDate;
        this.color = color;
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
        String dados = null;
        try {
           dados = "PostIt: {" +
                    "id=" + super.getId() +
                    ", title='" + super.getTitle() + '\'' +
                    ", description='" + super.getDescription() + '\'' +
                    ", due_date='" + dueDate + '\'' +
                    ", color='" + color + '\'' +
                    ", user='" + super.getUser().toString() + '\'' +
                    "}";
        }
        catch(NullPointerException e){
            //TRATAMENTO DA exceção
            System.out.println("Message:"+e.getMessage()+" . Para solucionar tal o problema, foi lhe atribuído um valor default.");

        }
        return dados;
    }
}
