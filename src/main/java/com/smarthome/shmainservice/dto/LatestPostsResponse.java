package com.smarthome.shmainservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smarthome.shmainservice.entity.Post;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestPostsResponse {

    private Set<Post> posts;

    public LatestPostsResponse() {
    }

    public static LatestPostsResponse fromPosts(Set<Post> posts) {
        LatestPostsResponse postResponse = new LatestPostsResponse();
        postResponse.posts = posts;
        return postResponse;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "LatestPostsResponse{" +
                "posts=" + posts +
                '}';
    }
}
