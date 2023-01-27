package com.board.bong.bongboard.domain.comment;

import com.board.bong.bongboard.domain.posts.Posts;
import com.board.bong.bongboard.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment; // 댓글 내용

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "posts_id")
    private Posts posts;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user; // 작성자


    @Builder
    public Comments(String comment, Posts posts, User user) {
        this.comment = comment;
        this.posts = posts;
        this.user = user;
    }

    public void update(String comment) {
        this.comment = comment;
    }
}
