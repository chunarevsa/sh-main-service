package com.socialhobbies.shmainservice.repo;

import com.socialhobbies.shmainservice.entity.MainInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainInfoRepository extends JpaRepository<MainInfo, Long> {

    Optional<MainInfo> findTop1ByOrderByIdDesc();

}
