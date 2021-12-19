package com.example.noteedu.notebook;

import com.example.noteedu.customExceptions.CustomException;
import com.example.noteedu.customExceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class NotebookService {

    private final NotebookRepository notebookRepository;

    @Autowired
    public NotebookService(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    public List<Notebook> getNotebooks() {
        return notebookRepository.findAll();
    }

    public Notebook createNotebook(Notebook notebook) {
        return notebookRepository.save(notebook);
    }

    @Transactional
    public void updateNotebook(Long id, String name, String color) throws NotFound, CustomException {
        Notebook notebook = notebookRepository.findById(id).orElseThrow(() -> new IllegalStateException("notebook with id "+ id + " does not exist"));
        if(name != null ) {
            if ( name.length() > 5 && !Objects.equals(notebook.getName(), name)){
                notebook.setName(name);
            } else {
                throw new CustomException();
            }
        } else{
            throw new NotFound();
        }

        if(color != null ) {
            if ( color.length() > 0 && !Objects.equals(notebook.getColor(), color)){
                notebook.setColor(color);
            } else {
                throw new CustomException();
            }
        } else{
            throw new NotFound();
        }
    }

    public void deleteNotebook(Long id) {
        Notebook notebook = notebookRepository.findById(id).orElseThrow(() -> new IllegalStateException("notebook with id "+ id + " does not exist"));

        notebookRepository.delete(notebook);
    }
}
