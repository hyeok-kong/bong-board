package com.board.bong.bongboard.web;


import com.board.bong.bongboard.service.comments.CommentsService;
import com.board.bong.bongboard.web.dto.comments.CommentsSaveRequestDto;
import com.board.bong.bongboard.web.dto.comments.CommentsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class CommentsApiController {

    private final CommentsService commentsService;

    @PostMapping("api/v1/posts/{id}/comments")
    public Long save(@PathVariable Long id, @RequestBody CommentsSaveRequestDto requestDto) {
        return commentsService.save(requestDto);
    }

    @PutMapping("api/v1/posts/{id}/comments")
    public Long update(@PathVariable Long id, @RequestBody CommentsUpdateRequestDto requestDto) {
        return commentsService.update(id, requestDto);
    }
}
