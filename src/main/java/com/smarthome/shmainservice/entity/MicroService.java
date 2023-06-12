package com.smarthome.mainservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class MicroService {

    @Id
    @Column(name = "MICROSERVICE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "LINK", nullable = false)
    private String link;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID", insertable = false, updatable = false)
    private MainInfo info;

    public MicroService() {
    }

    public MicroService(String name, String title, String link, MainInfo info) {
        this.name = name;
        this.title = title;
        this.link = link;
        this.info = info;
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

    public MainInfo getInfo() {
        return info;
    }

    public void setInfo(MainInfo info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "MicroService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", info=" + info +
                '}';
    }
}
