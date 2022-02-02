package com.example.noteedu.note;

import com.example.noteedu.customExceptions.CustomException;
import com.example.noteedu.customExceptions.NotFound;
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

    @Transactional
    public void updateNote(Long id, String title, String description) throws CustomException, NotFound {
        Note note = noteRepository.findById(id).orElseThrow(() -> new IllegalStateException("note with id "+ id + " does not exist"));

        if(title != null) {
            if (title.length() > 0 && !Objects.equals(note.getTitle(), title)) {
                note.setTitle(title);
            } else {
                throw new CustomException();
            }
        } else{
            throw new NotFound();
        }
        if(description != null){
            if ( description.length() >15 && !Objects.equals(note.getDescription(), description)){
                note.setDescription(description);
            } else {
                throw new CustomException();
            }
        } else {
            throw new NotFound();
        }
    }

    public void deleteNote(Long id) {
        Note note = noteRepository.findById(id).orElseThrow(() -> new IllegalStateException("note with id "+ id + " does not exist"));

        noteRepository.delete(note);
    }
}
