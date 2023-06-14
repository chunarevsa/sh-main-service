package com.smarthome.shmainservice.repo;

import com.smarthome.shmainservice.entity.MainInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MainRepository extends JpaRepository<MainInfo, Long> {
    @Query(value = "select * from main_info;") // TODO: Just do it
    Optional<MainInfo> findLastInfo();
}
