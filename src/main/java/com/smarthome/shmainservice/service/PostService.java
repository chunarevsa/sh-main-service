package com.smarthome.mainservice.service;

import com.smarthome.mainservice.dto.PostRequest;
import com.smarthome.mainservice.entity.Post;
import com.smarthome.mainservice.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }

    public Optional<Set<Post>> getLatestPosts() {
        return postRepository.findTop10ByOrderByCreatedDesc(); // TODO: check It is work?
    }

    public Optional<Post> addPost(PostRequest req) {
        return Optional.of(postRepository.save(new Post(req.getText(), req.getTitle(), req.getImageUrl())));
    }

    public Optional<Post> editPost(Long id, PostRequest req) {
        return postRepository.findById(id).map(post -> {
            post.setActive(req.getActive());
            post.setTitle(req.getTitle());
            post.setText(req.getText());
            post.setImageUrl(req.getImageUrl());
            // TODO check saved or not
            return post;
        });
    }

    public Optional<Post> deletePost(Long id) {
        return postRepository.findById(id).map(post -> {
            post.setActive(false);
            // TODO check saved or not
            return post;
        });
    }

    public Page<Post> getPageOfPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }
}
