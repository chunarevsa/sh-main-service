package com.smarthome.shmainservice.controller;

import com.smarthome.shmainservice.dto.ReferRequest;
import com.smarthome.shmainservice.entity.Refer;
import com.smarthome.shmainservice.service.ReferService;
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
@RequestMapping("/api/v1/refer")
public class RefersController {
    @Value("${spring.application.name}")
    private String applicationName;
    private static final String ENTITY_NAME = "refer";
    private final ReferService referService;

    @Autowired
    public RefersController(ReferService referService) {
        this.referService = referService;
    }

    @GetMapping()
    public List<Refer> getRefers() {
        return referService.getActualRefers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refer> getRefer(@PathVariable Long id) {
        return ResponseUtil.wrapOrNotFound(referService.getRefer(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Refer> addRefer(@RequestBody ReferRequest req) throws URISyntaxException {
        final Refer result = referService.addRefer(req);
        return ResponseEntity.created(new URI("/api/v1/refer/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    @PostMapping("/{id}/edit")
    public ResponseEntity updateRefer(@PathVariable(value = "id") Long id,  @RequestBody ReferRequest req) {
        final Optional<Refer> result = referService.updateRefer(id, req);
        return ResponseUtil.wrapOrNotFound(
                result,
                HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, id.toString())
        );
    }

    //POST /post/{id}/delete (front-service, discord-bot-service)
    @PostMapping("/{id}/delete")
    public ResponseEntity deleteRefer(@PathVariable(value = "id") Long id) {
        referService.deleteRefer(id);
        return ResponseEntity.noContent().headers(
                HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
