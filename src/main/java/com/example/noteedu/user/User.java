package com.example.noteedu.user;

import com.example.noteedu.customExceptions.CustomException;
import com.example.noteedu.customExceptions.NotFound;
import com.example.noteedu.customExceptions.WrongPassword;
import com.example.noteedu.note.Note;
import com.example.noteedu.reminder.Reminder;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import static jdk.nashorn.internal.objects.ArrayBufferView.length;

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

    public User(String name, String email, String password) {
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

    void checkPassword(String password) throws WrongPassword {
        if (!Objects.equals(this.getPassword(), password)){
            throw new WrongPassword();
        }
    }
    private void checkName(String name) throws CustomException {
        if (length(name)<8){
            throw new CustomException();
        }
    }

    private void checkEmail(String email) throws CustomException {
        if (length(email)<8){
            throw new CustomException();
        }
    }

    Class<? extends User> searchUser(String email)  throws NotFound {
        if (!Objects.equals(this.getEmail(), email)){
            throw new NotFound();
        }

        return this.getClass();
    }


}
