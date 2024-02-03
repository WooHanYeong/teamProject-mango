package com.itwill.jpa.dto.board;

import java.time.LocalDateTime;

import com.itwill.jpa.entity.board.BoardReply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardReplyDto {
	
	private Long boardReplyId;
    private String boardReplyTitle;
    private String boardReplyContent;
    private LocalDateTime createDateTime;

    public static BoardReplyDto toDto(BoardReply entity) {
    	return BoardReplyDto.builder()
    			 		 .boardReplyId(entity.getBoardReplyId())
    			 		 .boardReplyTitle(entity.getBoardReplyTitle())
    			 		 .boardReplyContent(entity.getBoardReplyContent())
    					 .build();
    }
}
