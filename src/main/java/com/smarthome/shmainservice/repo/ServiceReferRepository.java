package com.smarthome.shmainservice.repo;

import com.smarthome.shmainservice.entity.ServiceRefer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceReferRepository extends JpaRepository<ServiceRefer, Long> {
}
