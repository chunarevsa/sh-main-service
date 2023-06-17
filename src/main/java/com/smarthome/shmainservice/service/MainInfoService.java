package com.smarthome.shmainservice.service;

import com.smarthome.shmainservice.dto.MainInfoRequest;
import com.smarthome.shmainservice.entity.MainInfo;
import com.smarthome.shmainservice.repo.MainInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainInfoService {
    private final MainInfoRepository mainInfoRepository;

    @Autowired
    public MainInfoService(MainInfoRepository mainInfoRepository) {
        this.mainInfoRepository = mainInfoRepository;
    }

    public Optional<MainInfo> getActualMainInfo() {
        return mainInfoRepository.findTop1ByOrderByIdDesc();
    }

    public MainInfo addMainInfo(MainInfoRequest req) {
        return mainInfoRepository.save(new MainInfo(true, req.getText(), req.getTitle(), req.getImageUrl()));

    }

    public Optional<MainInfo> updateMainInfo(Long id, MainInfoRequest req) {
        return mainInfoRepository.findById(id).map(info -> {
            if (req.isActive() != null) info.setActive(req.isActive());
            if (req.getTitle() != null) info.setTitle(req.getTitle());
            if (req.getText() != null) info.setText(req.getText());
            if (req.getImageUrl() != null) info.setImageUrl(req.getImageUrl());
            // TODO check saved or not
            return info;
        });
    }

    public Optional<MainInfo> deactivateMainInfo(Long id) {
        return mainInfoRepository.findById(id).map(info -> {
            info.setActive(false);
            // TODO check saved or not
            return info;
        });
    }
}

