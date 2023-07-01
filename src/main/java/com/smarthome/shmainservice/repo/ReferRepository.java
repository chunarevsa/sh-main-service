package com.smarthome.shmainservice.repo;

import com.smarthome.shmainservice.entity.Refer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferRepository extends JpaRepository<Refer, Long> {
}
