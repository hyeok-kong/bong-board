package com.board.bong.bongboard.domain.posts;

import com.board.bong.bongboard.domain.BaseTimeEntity;
import com.board.bong.bongboard.web.dto.PostsUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@DynamicInsert
@Entity
public class Posts extends BaseTimeEntity {
    @Id // PK를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성규칙, IDENTITY == AUTO_INCREMENT
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @ColumnDefault("0")
    private Integer count;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
