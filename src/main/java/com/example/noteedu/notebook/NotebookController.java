package com.example.noteedu.notebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notebook")
public class NotebookController {

    private final NotebookService notebookService;

    @Autowired
    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @GetMapping
    public List<Notebook> index() {
        return notebookService.getNotebooks();
    }

    @PostMapping
    public Notebook create(@RequestBody Notebook notebook) {
        return notebookService.createNotebook(notebook);
    }

    @PutMapping(path = "{notebookId}")
    public void update(
            @PathVariable("notebookId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color) {
        notebookService.updateNotebook(id, name, color);
    }

    @PostMapping(path = "{notebookId}")
    public void delete(@PathVariable("notebookId") Long id) {
        notebookService.deleteNotebook(id);
    }
}
