package com.socialhobbies.shmainservice.service;

import com.socialhobbies.shmainservice.dto.PostRequest;
import com.socialhobbies.shmainservice.entity.Post;
import com.socialhobbies.shmainservice.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Page<Post> getPageOfPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public List<Post> getLatestPosts(Integer count) {
        return postRepository.findLastPosts(count);
    }

    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }

    public Post addPost(PostRequest req) {
        return postRepository.save(new Post(req.isActive(), req.getText(), req.getTitle(), req.getImageUrl()));
    }

    public Post updatePost(Long id, PostRequest req) throws Exception {
        Optional<Post> post = postRepository.findById(id).map(it -> {
            if (req.isActive() != null) it.setActive(req.isActive());
            if (req.getTitle() != null) it.setTitle(req.getTitle());
            if (req.getText() != null) it.setText(req.getText());
            if (req.getImageUrl() != null) it.setImageUrl(req.getImageUrl());
            return it;
        });
        return post.map(postRepository::save).orElseThrow(() -> new Exception("Not found"));
    }

    public Post deactivatePost(Long id) throws Exception {
        Optional<Post> post = postRepository.findById(id).map(it -> {
            it.setActive(false);
            return it;
        });

        return post.map(postRepository::save).orElseThrow(() -> new Exception("Not found"));
    }
}
