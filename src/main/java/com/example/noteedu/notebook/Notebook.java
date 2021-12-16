package com.example.noteedu.notebook;

import com.example.noteedu.note.Note;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Notebook {

    @Id
    @SequenceGenerator(
            name = "notebook_sequence",
            sequenceName = "notebook_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notebook_sequence"
    )
    private Long id;

    @Column(unique = true)
    private String name;

    private String color;

    @OneToMany(mappedBy = "notebook", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Note> notes;

    public Notebook() {
    }

    public Notebook(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Notebook(String name, String color, Set<Note> notes) {
        this.name = name;
        this.color = color;
        this.notes = notes;
    }

    public Notebook(Long id, String name, String color, Set<Note> notes) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Notebook: {" +
                "id=" + id +
                ", name='" + name + '\'' +
                "}";
    }
}
