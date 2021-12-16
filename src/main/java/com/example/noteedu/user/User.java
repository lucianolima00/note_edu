package com.example.noteedu.user;

import com.example.noteedu.note.Note;
import com.example.noteedu.reminder.Reminder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table

public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;

    @Column(unique = true)
    private String email;

    private String name;
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Note> notes;

    @ManyToMany(mappedBy = "guests")
    private Set<Reminder> reminders;


    public User() {

    }

    public Long getId() {
            return id;
        }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User: {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email=" + email + '\'' +
                "}";
    }

}
