package com.smarthome.shmainservice.repo;

import com.smarthome.shmainservice.entity.MainInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MainRepository extends JpaRepository<MainInfo, Long> {
    Optional<MainInfo> findTop10ByOrderByCreatedDesc();
}
