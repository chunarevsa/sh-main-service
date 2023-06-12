package com.smarthome.mainservice.repo;

import com.smarthome.mainservice.entity.MainInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MainRepository extends JpaRepository<MainInfo, Long> {
    Optional<MainInfo> findTop10ByOrderByCreatedDesc();
}
