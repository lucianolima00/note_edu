package com.example.noteedu.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        Note note = noteRepository.findById(id).orElseThrow(() -> new IllegalStateException("note with id "+ id + " does not exist"));

        noteRepository.delete(note);
    }

    @Transactional
    public void updateNote(Long id, String title, String description) {
        Note note = noteRepository.findById(id).orElseThrow(() -> new IllegalStateException("note with id "+ id + " does not exist"));

        if (title != null && title.length() > 0 && !Objects.equals(note.getTitle(), title)){
            note.setTitle(title);
        }

        if (description != null && description.length() > 0 && !Objects.equals(note.getDescription(), description)){
            note.setDescription(title);
        }
    }
}
