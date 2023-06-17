package com.smarthome.shmainservice.controller;

import com.smarthome.shmainservice.dto.MainInfoRequest;
import com.smarthome.shmainservice.entity.MainInfo;
import com.smarthome.shmainservice.entity.ServiceRefer;
import com.smarthome.shmainservice.service.MainService;
import com.smarthome.shmainservice.util.HeaderUtil;
import com.smarthome.shmainservice.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/main")
public class MainController {
    private final MainService mainService;

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping
    public ResponseEntity<MainInfo> getMainInfo() {
        return ResponseUtil.wrapOrNotFound(mainService.getActualMainInfo());
    }

    @GetMapping("/refers")
    public List<ServiceRefer> getServicesRefers() {
        return mainService.getActualServicesRefers();
    }

    @PostMapping("/info/add")
    public ResponseEntity<MainInfo> addMainInfo(@RequestBody MainInfoRequest req) throws URISyntaxException {
        final MainInfo result = mainService.addMainInfo(req);
        return ResponseEntity.created(new URI("/api/v1/post/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, "mainInfo", result.getId().toString()))
                .body(result);
    }

    @PostMapping("/info/{id}/edit")
    public ResponseEntity updatePost(@PathVariable(value = "id") Long id, MainInfoRequest req) {
        final Optional<MainInfo> result = mainService.updateMainInfo(id, req);
        return ResponseUtil.wrapOrNotFound(
                result,
                HeaderUtil.createEntityUpdateAlert(applicationName, false, "mainInfo", id.toString())
        );
    }

    //POST /post/{id}/delete (front-service, discord-bot-service)
    @PostMapping("/info/{id}/delete")
    public ResponseEntity deactivateMainInfo(@PathVariable(value = "id") Long id) {
        final Optional<MainInfo> result = mainService.deactivateMainInfo(id);
        return ResponseUtil.wrapOrNotFound(
                result,
                HeaderUtil.createEntityDeactivateAlert(applicationName, false, "mainInfo", id.toString())
        );
    }

}
