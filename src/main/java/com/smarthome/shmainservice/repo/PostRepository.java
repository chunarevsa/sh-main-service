package com.smarthome.shmainservice.repo;

import com.smarthome.shmainservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * FROM post ORDER BY post_id DESC LIMIT :count", nativeQuery = true)
    List<Post> findLastPosts(@Param("count") Integer count);

//    @Query(
//            value = "SELECT * FROM Users u WHERE u.status = ?1",
//            nativeQuery = true)
//    User findUserByStatusNative(Integer status);

    Optional<Post> findTop1ByOrderByIdDesc();
}
