package com.example.noteedu.postit;

import com.example.noteedu.note.Note;

import javax.persistence.*;

@Entity
@Table
public class PostIt extends Note {
    @Id
    @SequenceGenerator(
            name = "postit_sequence",
            sequenceName = "postit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "postit_sequence"
    )
    private long tagId;

    public PostIt(long id, String title, String description, long notebookId, long tagId) {
        this.tagId = tagId;
    }

    public PostIt() {

    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }
}
