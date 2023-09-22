package com.socialhobbies.shmainservice.controller;

import com.socialhobbies.shmainservice.dto.GetPostsRequest;
import com.socialhobbies.shmainservice.dto.PostRequest;
import com.socialhobbies.shmainservice.entity.Post;
import com.socialhobbies.shmainservice.service.PostService;
import com.socialhobbies.shmainservice.util.HeaderUtil;
import com.socialhobbies.shmainservice.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;

    private static final String ENTITY_NAME = "post";

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @PostMapping("/getPage")
    public Page<Post> getPageOfPosts(@RequestBody GetPostsRequest req) {
        return postService.getPageOfPosts(req.getPageable());
    }

    @GetMapping("/getLast/{count}")
    public List<Post> getLatestPosts(@PathVariable Integer count) {
        return postService.getLatestPosts(count);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        return ResponseUtil.wrapOrNotFound(postService.getPost(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Post> addPost(@RequestBody PostRequest req) throws URISyntaxException {
        final Post result = postService.addPost(req);
        return ResponseEntity.created(new URI("/api/v1/post/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<Post> updatePost(@PathVariable(value = "id") Long id, @RequestBody PostRequest req) throws Exception {
        final Post result = postService.updatePost(id, req);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    @PostMapping("/{id}/deactivate")
    public ResponseEntity<Post> deactivatePost(@PathVariable(value = "id") Long id) throws Exception {
        final Post result = postService.deactivatePost(id);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityDeactivateAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
}
