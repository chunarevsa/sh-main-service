package com.socialhobbies.shmainservice.service;

import com.socialhobbies.shmainservice.dto.MainInfoRequest;
import com.socialhobbies.shmainservice.entity.MainInfo;
import com.socialhobbies.shmainservice.repo.MainInfoRepository;
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
        Optional<MainInfo> oldInfo = getActualMainInfo();
        MainInfo newInfo = mainInfoRepository.save(new MainInfo(true, req.getText(), req.getTitle(), req.getImageUrl()));

        oldInfo.ifPresent(info -> {
            info.setActive(false);
            mainInfoRepository.save(info);
        });
        return newInfo;
    }
}

