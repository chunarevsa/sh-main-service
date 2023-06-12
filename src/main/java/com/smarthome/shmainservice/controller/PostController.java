package com.smarthome.mainservice.controller;

import com.smarthome.mainservice.dto.LatestPostsResponse;
import com.smarthome.mainservice.dto.PostResponse;
import com.smarthome.mainservice.dto.PostRequest;
import com.smarthome.mainservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/post")
//@PreAuthorize("hasRole('ADMIN')") // TODO: set up authorization
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    //GET /post/{id} (front-service, discord-bot-service)
    //RESP: Post
    @GetMapping("/{id}")
    public ResponseEntity getPost(@PathVariable(value = "id") Long id) throws Exception {
        return postService.getPost(id).map(post ->
                        ResponseEntity.ok(PostResponse.fromPost(post)))
                .orElseThrow(() -> new Exception("Post is not founded")); // TODO: add Exception
    }

    //GET /post/last (discord-bot-service) RESP: Set<Post>
    @GetMapping("/last")
    public ResponseEntity getLatestPosts() throws Exception {
        return postService.getLatestPosts().map(posts ->
                        ResponseEntity.ok(LatestPostsResponse.fromPosts(posts)))
                .orElseThrow(() -> new Exception("Posts are not founded")); // TODO: add Exception
    }

    //POST /post/add (front-service, discord-bot-service)
    @PostMapping("/add")
    public ResponseEntity addPost(PostRequest req) throws Exception {
        return postService.addPost(req).map(post ->
                        ResponseEntity.ok(PostResponse.fromPost(post)))
                .orElseThrow(() -> new Exception("Post is added")); // TODO: add Exception
    }

    //POST /post/{id}/edit (front-service, discord-bot-service)
    @PostMapping("/{id}/edit")
    public ResponseEntity editPost(@PathVariable(value = "id") Long id, PostRequest req) throws Exception {
        return postService.editPost(id ,req).map(post ->
                        ResponseEntity.ok(PostResponse.fromPost(post)))
                .orElseThrow(() -> new Exception("Post is not edited")); // TODO: add Exception
    }

    //POST /post/{id}/delete (front-service, discord-bot-service)
    @PostMapping("/{id}/delete")
    public ResponseEntity deletePost(@PathVariable(value = "id") Long id) throws Exception {
        return postService.deletePost(id).map(post ->
                        ResponseEntity.ok(PostResponse.fromPost(post)))
                .orElseThrow(() -> new Exception("Post is not deleted")); // TODO: add Exception
    }

}
