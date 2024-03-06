package controller;

import lombok.RequiredArgsConstructor;
import model.Posts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/api")
public class PostController {
    private final PostService postService;

    @GetMapping("/post")
    public List<Posts> getAllPosts() {
        return postService.getAllPosts();
    }
}
