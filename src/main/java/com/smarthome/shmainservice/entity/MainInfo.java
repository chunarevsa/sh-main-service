package com.smarthome.shmainservice.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "main_info")
public class MainInfo {

    @Id
    @Column(name = "main_info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @JoinColumn(nullable = false, updatable = false)
    private Instant created;

    @LastModifiedDate
    @JoinColumn(nullable = false)
    private Instant updated;

    @Column(nullable = false)
    private String title;

    @Column(name = "welcome_text", nullable = false)
    private String welcomeText;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    public MainInfo() {
    }

    public MainInfo(String title, String welcomeText, String imageUrl) {
        this.title = title;
        this.welcomeText = welcomeText;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public Instant getCreated() {
        return created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWelcomeText() {
        return welcomeText;
    }

    public void setWelcomeText(String welcomeText) {
        this.welcomeText = welcomeText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "MainInfo{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                ", title='" + title + '\'' +
                ", welcomeText='" + welcomeText + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

}
