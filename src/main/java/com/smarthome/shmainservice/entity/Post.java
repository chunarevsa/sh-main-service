package com.smarthome.shmainservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post implements DataAuditing{

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "active", nullable = false)
    private Boolean active;

//    @CreatedDate
//    @JoinColumn(nullable = false, updatable = false)
//    private Instant created;
//
//    @LastModifiedDate
//    @JoinColumn(nullable = false)
//    private Instant updated;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private String title;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    public Post() {
    }

    public Post(Boolean active, String text, String title, String imageUrl) {
        this.active = active;
        this.text = text;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

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
        return "Post{" +
                "id=" + id +
                ", active=" + active +
//                ", created=" + created +
//                ", updated=" + updated +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
