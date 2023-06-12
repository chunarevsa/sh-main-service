package com.smarthome.mainservice.controller;

import com.smarthome.mainservice.dto.MainInfoResponse;
import com.smarthome.mainservice.entity.MainInfo;
import com.smarthome.mainservice.entity.Post;
import com.smarthome.mainservice.service.MainService;
import com.smarthome.mainservice.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/main")
//@PreAuthorize("hasRole('USER')") // TODO: set up authorization
// TODO: Just do it: Common module for Auth
public class MainController {

    private final PostService postService;
    private final MainService mainService;

    public MainController(PostService postService, MainService mainService) {
        this.postService = postService;
        this.mainService = mainService;
    }

    //GET /main RESP: Info, Page<Post>, Map<nameService, reference>
    //(front-service)
    @GetMapping
    public ResponseEntity getMainPage(Pageable pageable) {
        Page<Post> pageOfPosts;
        MainInfo mainInfo;
        try {
            mainInfo = mainService.getMainInfo().orElseThrow(() -> new Exception("Can't load main info"));
            pageOfPosts = postService.getPageOfPosts(pageable);
        } catch (Exception e) {
            // TODO add logging
            return ResponseEntity.internalServerError().body(e);
        }

        return ResponseEntity.ok().body(new MainInfoResponse(mainInfo, pageOfPosts));
    }

    //POST /main/logout (front-service) | auth
    @PostMapping("/logout")
    public ResponseEntity logout() {
        // TODO: Just do it: Common module for Auth
        // TODO: Just do it /main/logout (front-service) | auth
        return ResponseEntity.ok().body(null);
    }
}
