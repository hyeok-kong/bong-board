package com.board.bong.bongboard.web.dto.comments;

import com.board.bong.bongboard.domain.comment.Comments;
import com.board.bong.bongboard.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.board.bong.bongboard.domain.user.User;

@Getter
@NoArgsConstructor
public class CommentsSaveRequestDto {
    private String comment;
    private Posts posts;
    private User user;

    @Builder
    public CommentsSaveRequestDto(String comment, Posts posts, User user) {
        this.comment = comment;
        this.posts = posts;
        this.user = user;
    }

    public Comments toEntity() {
        return Comments.builder()
                .comment(comment)
                .posts(posts)
                .user(user)
                .build();
    }

}
