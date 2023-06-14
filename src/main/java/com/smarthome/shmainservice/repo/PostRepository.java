package com.smarthome.shmainservice.repo;

import com.smarthome.shmainservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface PostRepository extends JpaRepository<Post, Long> {
    Set<Post> findTop10ByOrderByCreatedDesc(); // TODO: check this (repo)

    @Query("") // TODO Just Do It!
    List<Post> findLastPosts(Long count); // TODO: check this (repo)
}
