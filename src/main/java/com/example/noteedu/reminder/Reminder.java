package com.example.noteedu.reminder;

import com.example.noteedu.note.Note;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reminder extends Note {
    private Date dueDate;
    private long tagId;

    public Reminder() {
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
