package com.smarthome.shmainservice.dto;

import org.springframework.data.domain.Pageable;

public class GetPostsRequest {
    private Pageable pageable;

    public GetPostsRequest(Pageable pageable) {
        this.pageable = pageable;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    @Override
    public String toString() {
        return "GetPostsRequest{" +
                "pageable=" + pageable +
                '}';
    }
}
