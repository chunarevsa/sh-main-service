package com.socialhobbies.shmainservice.dto;

public class ReferRequest {

    private String name;
    private String title;
    private String link;
    private Boolean serviceRefer;

    public ReferRequest(String name, String title, String link, Boolean isServiceRefer) {
        this.name = name;
        this.title = title;
        this.link = link;
        this.serviceRefer = isServiceRefer;
    }

    public ReferRequest() {}

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
        return serviceRefer;
    }

    public void setServiceRefer(Boolean serviceRefer) {
        this.serviceRefer = serviceRefer;
    }

    @Override
    public String toString() {
        return "ReferRequest{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", serviceRefer=" + serviceRefer +
                '}';
    }
}
