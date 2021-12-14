package com.example.noteedu.postit;

import com.example.noteedu.note.Note;

public class PostIt extends Note {
    private long tagId;

    public PostIt(long id, String title, String description, long notebookId, long tagId) {
        this.tagId = tagId;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }
}
