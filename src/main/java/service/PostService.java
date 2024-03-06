package service;

import lombok.RequiredArgsConstructor;
import model.Posts;
import org.springframework.stereotype.Service;
import repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Posts> getAllPosts() {
        return postRepository.findAll();
    }
}
