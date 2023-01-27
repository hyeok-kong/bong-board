package com.board.bong.bongboard.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Modifying
    @Query("update Posts p set p.viewCount = p.viewCount + 1 where p.id = :id")
    Long increaseViewCount(Long id);
}
