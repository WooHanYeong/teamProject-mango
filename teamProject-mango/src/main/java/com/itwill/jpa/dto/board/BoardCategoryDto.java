package com.itwill.jpa.dto.board;

import com.itwill.jpa.entity.board.BoardCategory;

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
public class BoardCategoryDto {
	
	private Long id;
	private String  boardCategoryName;
	
	public static BoardCategoryDto toDto(BoardCategory entity) {
		return BoardCategoryDto.builder()
							.id(entity.getId())
							.boardCategoryName(entity.getBoardCategoryName())
							.build();
	}
}
