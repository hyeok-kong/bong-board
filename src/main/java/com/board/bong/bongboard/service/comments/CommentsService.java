package com.board.bong.bongboard.service.comments;

import com.board.bong.bongboard.domain.comment.Comments;
import com.board.bong.bongboard.domain.comment.CommentsRepository;
import com.board.bong.bongboard.web.dto.comments.CommentsSaveRequestDto;
import com.board.bong.bongboard.web.dto.comments.CommentsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    public Long save(CommentsSaveRequestDto requestDto) {
        return commentsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, CommentsUpdateRequestDto requestDto) {
        Comments comments = commentsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 없습니다. id="+id));

        comments.update(requestDto.getComment());

        return id;
    }
}
