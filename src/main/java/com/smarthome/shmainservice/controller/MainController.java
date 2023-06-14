package com.smarthome.shmainservice.controller;

import com.smarthome.shmainservice.entity.MainInfo;
import com.smarthome.shmainservice.entity.ServiceRefer;
import com.smarthome.shmainservice.service.MainService;
import com.smarthome.shmainservice.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/main")
public class MainController {
    private final MainService mainService;

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

}
