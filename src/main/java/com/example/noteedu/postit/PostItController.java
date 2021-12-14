package com.example.noteedu.postit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/reminder")
public class PostItController {

    private final PostItService postItService;

    @Autowired
    public PostItController(PostItService postItService) {
        this.postItService = postItService;
    }

    @GetMapping
    public List<PostIt> getPostIts() {
        return postItService.getPostIts();
    }
}
