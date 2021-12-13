package com.example.noteedu.models;

public class Note {
    private final long id;
    private String title;
    private String description;
    private long notebookId;

    public Note(long id, String title, String description, long notebookId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.notebookId = notebookId;
    }

    public long getId() {
        return id;
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

    public long getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(long notebookId) {
        this.notebookId = notebookId;
    }


}
