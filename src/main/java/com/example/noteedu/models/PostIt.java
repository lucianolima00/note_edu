package com.example.noteedu.models;

public class PostIt extends Note {
    private long tagId;

    public PostIt(long id, String title, String description, long notebookId, long tagId) {
        super(id, title, description, notebookId);
        this.tagId = tagId;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }
}
