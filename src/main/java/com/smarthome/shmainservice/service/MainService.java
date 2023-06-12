package com.smarthome.shmainservice.service;

import com.smarthome.shmainservice.entity.MainInfo;
import com.smarthome.shmainservice.repo.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainService {

    private final MainRepository mainRepository;

    @Autowired
    public MainService(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public Optional<MainInfo> getMainInfo() {
        return mainRepository.findTop10ByOrderByCreatedDesc(); // TODO: check It is Work?
    }
}
