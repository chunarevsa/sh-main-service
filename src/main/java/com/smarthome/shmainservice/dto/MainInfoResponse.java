package com.smarthome.mainservice.dto;

import com.smarthome.mainservice.entity.MainInfo;
import com.smarthome.mainservice.entity.Post;
import org.springframework.data.domain.Page;

public class MainInfoResponse {

    private MainInfo mainInfo;
    private Page<Post> pageOfPosts;

    public MainInfoResponse() {
    }

    public MainInfoResponse(MainInfo mainInfo, Page<Post> pageOfPosts) {
        this.mainInfo = mainInfo;
        this.pageOfPosts = pageOfPosts;
    }

    public MainInfo getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(MainInfo mainInfo) {
        this.mainInfo = mainInfo;
    }

    public Page<Post> getPageOfPosts() {
        return pageOfPosts;
    }

    public void setPageOfPosts(Page<Post> pageOfPosts) {
        this.pageOfPosts = pageOfPosts;
    }

    @Override
    public String toString() {
        return "MainInfoResponse{" +
                "mainInfo=" + mainInfo +
                ", pageOfPosts=" + pageOfPosts +
                '}';
    }
}
