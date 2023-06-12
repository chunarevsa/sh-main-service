package com.smarthome.mainservice.repo;

import com.smarthome.mainservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Set<Post>> findTop10ByOrderByCreatedDesc(); // TODO: check this (repo)

}
