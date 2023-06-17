package com.smarthome.shmainservice.controller;

import com.smarthome.shmainservice.dto.GetPostsRequest;
import com.smarthome.shmainservice.dto.PostRequest;
import com.smarthome.shmainservice.entity.Post;
import com.smarthome.shmainservice.service.PostService;
import com.smarthome.shmainservice.util.HeaderUtil;
import com.smarthome.shmainservice.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("/getPage")
    public Page<Post> getPageOfPosts(GetPostsRequest req) {
        return postService.getPageOfPosts(req.getPageable());
    }

    //GET /post/{id} (front-service, discord-bot-service)
    //RESP: Post
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        return ResponseUtil.wrapOrNotFound(postService.getPost(id));
    }

    //GET /post/last (discord-bot-service) RESP: Set<Post>
    @GetMapping("/getLast/{count}")
    public List<Post> getLatestPosts(@PathVariable Long count) {
        return postService.getLatestPosts(count);
    }

    //POST /post/add (front-service, discord-bot-service)
    @PostMapping("/add")
    public ResponseEntity<Post> addPost(@RequestBody PostRequest req) throws URISyntaxException {
        final Post result = postService.addPost(req);
        return ResponseEntity.created(new URI("/api/v1/post/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    //POST /post/{id}/edit (front-service, discord-bot-service)
    @PostMapping("/{id}/edit")
    public ResponseEntity updatePost(@PathVariable(value = "id") Long id, PostRequest req) {
        final Optional<Post> result = postService.updatePost(id, req);
        return ResponseUtil.wrapOrNotFound(
                result,
                HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, id.toString())
        );
    }

    //POST /post/{id}/delete (front-service, discord-bot-service)
    @PostMapping("/{id}/delete")
    public ResponseEntity deactivateTEPost(@PathVariable(value = "id") Long id) {
        final Optional<Post> result = postService.deactivatePost(id);
        return ResponseUtil.wrapOrNotFound(
                result,
                HeaderUtil.createEntityDeactivateAlert(applicationName, false, ENTITY_NAME, id.toString())
        );
    }
}
