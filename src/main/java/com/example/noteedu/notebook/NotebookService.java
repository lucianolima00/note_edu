package com.example.noteedu.notebook;

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
    public void updateNotebook(Long id, String name, String color) {
        Notebook notebook = notebookRepository.findById(id).orElseThrow(() -> new IllegalStateException("notebook with id "+ id + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(notebook.getName(), name)){
            notebook.setName(name);
        }

        if (color != null && color.length() > 0 && !Objects.equals(notebook.getColor(), color)){
            notebook.setColor(color);
        }
    }

    public void deleteNotebook(Long id) {
        Notebook notebook = notebookRepository.findById(id).orElseThrow(() -> new IllegalStateException("notebook with id "+ id + " does not exist"));

        notebookRepository.delete(notebook);
    }
}
