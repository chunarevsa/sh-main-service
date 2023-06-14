package com.smarthome.shmainservice.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_active", nullable = false)
    private Boolean active;

    @CreatedDate
    @JoinColumn(nullable = false, updatable = false)
    private Instant created;

    @LastModifiedDate
    @JoinColumn(nullable = false)
    private Instant updated;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private String title;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    public Post() {
    }

    public Post(String text, String title, String imageUrl) {
        this.active = true;
        this.created = Instant.now();
        this.updated = Instant.now();
        this.text = text;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public Boolean getActive() {
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
        return "Post{" +
                "id=" + id +
                ", active=" + active +
                ", created=" + created +
                ", updated=" + updated +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
