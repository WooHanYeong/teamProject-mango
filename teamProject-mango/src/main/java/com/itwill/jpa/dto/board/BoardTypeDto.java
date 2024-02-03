package com.itwill.jpa.dto.board;

import com.itwill.jpa.entity.board.BoardType;

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
public class BoardTypeDto {
	
    private Long typeId;
    private String boardTypeTitle;
    
    public static BoardTypeDto toDto(BoardType entity) {
    	return BoardTypeDto.builder()
    					   .typeId(entity.getTypeId())
    					   .boardTypeTitle(entity.getBoardTypeTitle())
    					   .build();
    }
}
