package com.board.bong.bongboard.domain;

import com.board.bong.bongboard.domain.comment.Comments;
import com.board.bong.bongboard.domain.comment.CommentsRepository;
import com.board.bong.bongboard.domain.posts.Posts;
import com.board.bong.bongboard.domain.posts.PostsRepository;
import com.board.bong.bongboard.domain.user.Role;
import com.board.bong.bongboard.domain.user.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentsRepositoryTest {

    @Autowired
    CommentsRepository commentsRepository;

    @After
    public void set() {
        commentsRepository.deleteAll();
    }

    @Test
    public void register_comment() {
        //given
        String content = "테스트 댓글";

        Posts posts = Posts.builder()
                .title("테스트 게시글")
                .content("테스트입니다")
                .build();

        User user = User.builder()
                .name("유저")
                .email("test@test")
                .role(Role.USER)
                .build();

        commentsRepository.save(Comments.builder()
                .comment(content)
                .user(user)
                .posts(posts)
                .build());

        //when
        List<Comments> comments = commentsRepository.getCommentByPosts(posts);

        //then
        Comments comment = comments.get(0);
        assertThat(comment.getComment()).isEqualTo(content);
        assertThat(user.getName()).isEqualTo("유저");
        assertThat(user.getEmail()).isEqualTo("test@test");
    }
}
