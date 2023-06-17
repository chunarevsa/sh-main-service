package com.smarthome.shmainservice.service;

import com.smarthome.shmainservice.dto.PostRequest;
import com.smarthome.shmainservice.entity.Post;
import com.smarthome.shmainservice.repo.PostRepository;
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

    public List<Post> getLatestPosts(Long count) {
        return postRepository.findAll(); // TODO: findLast
    }

    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }

    public Post addPost(PostRequest req) {
        return postRepository.save(new Post(req.isActive(), req.getText(), req.getTitle(), req.getImageUrl()));
    }

    public Optional<Post> updatePost(Long id, PostRequest req) {
        return postRepository.findById(id).map(post -> {
            if (req.isActive() != null) post.setActive(req.isActive());
            if (req.getTitle() != null) post.setTitle(req.getTitle());
            if (req.getText() != null) post.setText(req.getText());
            if (req.getImageUrl() != null) post.setImageUrl(req.getImageUrl());
            // TODO check saved or not
            return post;
        });
    }

    public Optional<Post> deactivatePost(Long id) {
        return postRepository.findById(id).map(post -> {
            post.setActive(false);
            // TODO check saved or not
            return post;
        });
    }
}
