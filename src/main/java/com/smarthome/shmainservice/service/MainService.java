package com.smarthome.shmainservice.service;

import com.smarthome.shmainservice.entity.MainInfo;
import com.smarthome.shmainservice.entity.ServiceRefer;
import com.smarthome.shmainservice.repo.MainRepository;
import com.smarthome.shmainservice.repo.ServiceReferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainService {
    private final MainRepository mainRepository;
    private final ServiceReferRepository serviceReferRepository;

    @Autowired
    public MainService(MainRepository mainRepository, ServiceReferRepository serviceReferRepository) {
        this.mainRepository = mainRepository;
        this.serviceReferRepository = serviceReferRepository;
    }

    public Optional<MainInfo> getActualMainInfo() {
        return mainRepository.findLastInfo();
    }

    public List<ServiceRefer> getActualServicesRefers() {
        return serviceReferRepository.findAll();
    }
}

