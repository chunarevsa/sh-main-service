package com.socialhobbies.shmainservice.controller;

import com.socialhobbies.shmainservice.dto.ReferRequest;
import com.socialhobbies.shmainservice.entity.Refer;
import com.socialhobbies.shmainservice.service.ReferService;
import com.socialhobbies.shmainservice.util.HeaderUtil;
import com.socialhobbies.shmainservice.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/refer")
public class ReferController {
    @Value("${spring.application.name}")
    private String applicationName;
    private static final String ENTITY_NAME = "refer";
    private final ReferService referService;

    @Autowired
    public ReferController(ReferService referService) {
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

    @PostMapping("/{id}/update")
    public ResponseEntity<Refer> updateRefer(@PathVariable(value = "id") Long id,  @RequestBody ReferRequest req) throws Exception {
        final Refer result = referService.updateRefer(id, req);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<Refer> deleteRefer(@PathVariable(value = "id") Long id) {
        referService.deleteRefer(id);
        return ResponseEntity.noContent().headers(
                HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
