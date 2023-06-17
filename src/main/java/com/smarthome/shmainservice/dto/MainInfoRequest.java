package com.smarthome.shmainservice.dto;

public class MainInfoRequest {

    private Boolean active;
    private String text;
    private String title;
    private String imageUrl;

    public MainInfoRequest(Boolean active, String text, String title, String imageUrl) {
        this.active = active;
        this.text = text;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public MainInfoRequest() {}

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
        return "MainInfoRequest{" +
                "active=" + active +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
