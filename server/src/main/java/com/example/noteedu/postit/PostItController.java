package com.example.noteedu.postit;

import com.example.noteedu.customExceptions.CustomException;
import com.example.noteedu.customExceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/postIt")
public class PostItController {

    private final PostItService postItService;

    @Autowired
    public PostItController(PostItService postItService) {
        this.postItService = postItService;
    }

    @GetMapping
    public List<PostIt> index() {
        return postItService.getPostIts();
    }

    @PostMapping
    public PostIt create(@RequestBody PostIt postIt) {
        return postItService.createPostIt(postIt);
    }

    @PutMapping(path = "{postItId}")
    public void update(
            @PathVariable("postItId") Long id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description) throws CustomException, NotFound {
        postItService.updatePostIt(id,title, description);
    }

    @PostMapping(path = "{postItId}")
    public void delete(@PathVariable("postItId") Long id) {
        postItService.deletePostIt(id);
    }
}
