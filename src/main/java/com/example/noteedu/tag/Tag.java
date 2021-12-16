package com.example.noteedu.tag;

import com.example.noteedu.reminder.Reminder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Tag {

    @Id
    @SequenceGenerator(
            name = "tag_sequence",
            sequenceName = "tag_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tag_sequence"
    )
    private Long id;

    @Column(unique = true)
    private String name;

    private String color;

    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Reminder> reminders;

    public Tag() {
    }

    public Tag(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Tag(String name, String color, Set<Reminder> reminders) {
        this.name = name;
        this.color = color;
        this.reminders = reminders;
    }

    public Tag(Long id, String name, String color, Set<Reminder> reminders) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.reminders = reminders;
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
        return "Tag: {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                "}";
    }
}
