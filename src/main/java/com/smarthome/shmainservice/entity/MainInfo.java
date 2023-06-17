package com.smarthome.shmainservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "main_info")
public class MainInfo extends DateAudit {

    @Id
    @Column(name = "main_info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    public MainInfo() {
    }

    public MainInfo(Boolean active, String title, String text, String imageUrl) {
        this.title = title;
        this.text = text;
        this.imageUrl = imageUrl;
        this.active = active;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "MainInfo{" +
                "id=" + id +
                ", active=" + active +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
