package com.moe.springsecuritydemo.service;

import lombok.RequiredArgsConstructor;
import com.moe.springsecuritydemo.model.Posts;
import org.springframework.stereotype.Service;
import com.moe.springsecuritydemo.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Posts> getAllPosts() {
        return postRepository.findAll();
    }
}
