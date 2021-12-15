package com.example.noteedu.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tag")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<Tag> index() {
        return tagService.getTags();
    }

    @PostMapping
    public Tag create(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

    @PutMapping(path = "{tagId}")
    public void update(
            @PathVariable("tagId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color) {
        tagService.updateTag(id, name, color);
    }

    @PostMapping(path = "{tagId}")
    public void delete(@PathVariable("tagId") Long id) {
        tagService.deleteTag(id);
    }
}
