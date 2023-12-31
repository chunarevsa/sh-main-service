package com.socialhobbies.shmainservice.repo;

import com.socialhobbies.shmainservice.entity.Refer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferRepository extends JpaRepository<Refer, Long> {
}
