package com.smarthome.mainservice.dto;

import com.smarthome.mainservice.entity.Post;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostResponse {

    private Long id;
    private String text;
    private String title;
    private String imageUrl;

    public PostResponse() {
    }

    public static PostResponse fromPost(Post post) {
        PostResponse postResponse = new PostResponse();
        postResponse.id = post.getId();
        postResponse.text = post.getText();
        postResponse.title = post.getTitle();
        postResponse.imageUrl = post.getImageUrl();
        return postResponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "PostResponse{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
