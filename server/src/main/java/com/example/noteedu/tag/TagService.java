package com.example.noteedu.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional
    public void updateTag(Long id, String name, String color) {
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new IllegalStateException("tag with id "+ id + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(tag.getName(), name)){
            tag.setName(name);
        }

        if (color != null && color.length() > 0 && !Objects.equals(tag.getColor(), color)){
            tag.setColor(color);
        }
    }

    public void deleteTag(Long id) {
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new IllegalStateException("tag with id "+ id + " does not exist"));

        tagRepository.delete(tag);
    }
}
