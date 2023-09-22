package com.socialhobbies.shmainservice.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "refer")
public class Refer extends DateAudit {

    @Id
    @Column(name = "refer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NaturalId
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private Boolean isServiceRefer;

    public Refer() {
    }

    public Refer(String name, String title, String link, Boolean isServiceRefer) {
        this.name = name;
        this.title = title;
        this.link = link;
        this.isServiceRefer = isServiceRefer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean isServiceRefer() {
        return isServiceRefer;
    }

    public void setIsServiceRefer(Boolean serviceRefer) {
        isServiceRefer = serviceRefer;
    }

    @Override
    public String toString() {
        return "Refer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", isServiceRefer=" + isServiceRefer +
                '}';
    }
}
