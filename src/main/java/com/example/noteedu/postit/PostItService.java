package com.example.noteedu.postit;

import com.example.noteedu.customExceptions.CustomException;
import com.example.noteedu.customExceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class PostItService {

    private final PostItRepository postItRepository;

    @Autowired
    public PostItService(PostItRepository postItRepository) {
        this.postItRepository = postItRepository;
    }

    public List<PostIt> getPostIts() {
        return postItRepository.findAll();
    }

    public PostIt createPostIt(PostIt postIt) {
        return postItRepository.save(postIt);
    }

    @Transactional
    public void updatePostIt(Long id, String title, String description) throws CustomException, NotFound {
        PostIt postIt = postItRepository.findById(id).orElseThrow(() -> new IllegalStateException("postIt with id "+ id + " does not exist"));
        if(title != null) {
            if (title.length() > 0 && !Objects.equals(postIt.getTitle(), title)) {
                postIt.setTitle(title);
            } else {
                throw new CustomException();
            }
        } else{
            throw new NotFound();
        }
        if(description != null){
            if ( description.length() >15 && !Objects.equals(postIt.getDescription(), description)){
                postIt.setDescription(description);
            } else {
                throw new CustomException();
            }
        } else {
            throw new NotFound();
        }


    }

    public void deletePostIt(Long id) {
        PostIt postIt = postItRepository.findById(id).orElseThrow(() -> new IllegalStateException("postIt with id "+ id + " does not exist"));
        postItRepository.delete(postIt);
    }
}
