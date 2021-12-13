package com.example.noteedu.models;

import java.util.Date;

public class Remider extends Note {
    private Date dueDate;
    private long tagId;

    public Remider(long id, String title, String description, long notebookId, Date dueDate, long tagId) {
        super(id, title, description, notebookId);
        this.dueDate = dueDate;
        this.tagId = tagId;
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
