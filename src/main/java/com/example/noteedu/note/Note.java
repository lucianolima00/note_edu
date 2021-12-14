package com.example.noteedu.note;


public class Note {
    private Long id;
    private String title;
    private String description;

    private Long notebookId;

    public Note(Long id, String title, String description, Long notebookId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.notebookId = notebookId;
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

    public Long getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(Long notebookId) {
        this.notebookId = notebookId;
    }


}
