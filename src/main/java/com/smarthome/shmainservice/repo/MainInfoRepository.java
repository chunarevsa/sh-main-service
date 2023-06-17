package com.smarthome.shmainservice.repo;

import com.smarthome.shmainservice.entity.MainInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MainInfoRepository extends JpaRepository<MainInfo, Long> {
    @Query(value = "SELECT * FROM main_info ORDER BY main_info_id DESC LIMIT 1", nativeQuery = true)
    MainInfo findLastInfo();

    Optional<MainInfo> findTop1ByOrderByIdDesc();

}
