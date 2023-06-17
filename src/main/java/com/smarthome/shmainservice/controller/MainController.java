package com.smarthome.shmainservice.controller;

import com.smarthome.shmainservice.dto.MainInfoRequest;
import com.smarthome.shmainservice.entity.MainInfo;
import com.smarthome.shmainservice.service.MainInfoService;
import com.smarthome.shmainservice.util.HeaderUtil;
import com.smarthome.shmainservice.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/mainInfo")
public class MainController {
    private final MainInfoService mainInfoService;

    @Value("${spring.application.name}")
    private String applicationName;

    private static final String ENTITY_NAME = "mainInfo";

    @Autowired
    public MainController(MainInfoService mainInfoService) {
        this.mainInfoService = mainInfoService;
    }

    @GetMapping
    public ResponseEntity<MainInfo> getActualMainInfo() {
        return ResponseUtil.wrapOrNotFound(mainInfoService.getActualMainInfo());
    }

    @PostMapping("/add")
    public ResponseEntity<MainInfo> addMainInfo(@RequestBody MainInfoRequest req) throws URISyntaxException {
        final MainInfo result = mainInfoService.addMainInfo(req);
        return ResponseEntity.created(new URI("/api/v1/mainInfo/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    @PostMapping("/{id}/edit")
    public ResponseEntity updateMainInfo(@PathVariable(value = "id") Long id, MainInfoRequest req) {
        final Optional<MainInfo> result = mainInfoService.updateMainInfo(id, req);
        return ResponseUtil.wrapOrNotFound(
                result,
                HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, id.toString())
        );
    }

    //POST /post/{id}/delete (front-service, discord-bot-service)
    @PostMapping("/{id}/deactivate")
    public ResponseEntity deactivateMainInfo(@PathVariable(value = "id") Long id) {
        final Optional<MainInfo> result = mainInfoService.deactivateMainInfo(id);
        return ResponseUtil.wrapOrNotFound(
                result,
                HeaderUtil.createEntityDeactivateAlert(applicationName, false, ENTITY_NAME, id.toString())
        );
    }

}
