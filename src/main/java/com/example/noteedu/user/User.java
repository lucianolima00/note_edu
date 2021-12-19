package com.example.noteedu.user;

import java.util.Set;
import java.util.Objects;
import javax.persistence.*;
import com.example.noteedu.note.Note;
import com.example.noteedu.reminder.Reminder;
import com.example.noteedu.customExceptions.NotFound;
import com.example.noteedu.customExceptions.WrongPassword;
import com.example.noteedu.customExceptions.CustomException;
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

    public User(String name, String email, String password, Long id) {
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

    public void checkPassword(String password) throws WrongPassword{
        if (!Objects.equals(this.getPassword(), User.this.password)){
            throw new WrongPassword();
        }
    }
    public int searchUser(String email) throws NotFound {
        //conectar no banco de dados
        //buscar usu�rio por email
        //retornar usu�rio encontrado
        //se n�o encontrado, throw new NotFound();
        //placeholder

        if (!Objects.equals(this.getEmail(), User.this.email)){
            throw new NotFound();
        }

        return Math.toIntExact(this.id);
    }

    @Override
    public String toString() {
        return "User: {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email=" + email + '\'' +
                "}";
    }
    public int update(String name, String email, String password, Long id)throws NotFound, CustomException {

        //conectar no banco de dados
        //buscar usu�rio por email
        //retornar usu�rio encontrado
        //se n�o encontrado, throw new NotFound();
        //placeholder

        if (!Objects.equals(this.getEmail(), User.this.email)){
            throw new NotFound();
        }
        if (length(password)<12){
            throw new CustomException();
        }
        if (length(name)<8){
            throw new CustomException();
        }

        return Math.toIntExact(this.id);
    }

}
