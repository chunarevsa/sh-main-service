package com.smarthome.shmainservice.repo;

import com.smarthome.shmainservice.entity.MainInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MainInfoRepository extends JpaRepository<MainInfo, Long> {

    Optional<MainInfo> findTop1ByOrderByIdDesc();

}
