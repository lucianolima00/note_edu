package com.example.noteedu.note;

import com.example.noteedu.user.User;

import javax.persistence.*;

@Entity
@Table
public abstract class Note {
    @Id
    @SequenceGenerator(
            name = "note_sequence",
            sequenceName = "note_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "note_sequence"
    )
    private Long id;
    private String title;
    private String description;
    private Boolean finished;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Note() {}

    public Note(Long id, String title, String description, Boolean finished, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.finished = finished;
        this.user = user;
    }

    public Note(String title, String description, Boolean finished) {
        this.title = title;
        this.description = description;
        this.finished = finished;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public abstract void execute();

    @Override
    public String toString() {
        return "Note: {" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description=" + description + '\'' +
                ", user=" + user.toString() + '\'' +
                "}";
    }
}
