package com.board.bong.bongboard.domain.comment;

import com.board.bong.bongboard.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> getCommentByPosts(Posts posts);
}
