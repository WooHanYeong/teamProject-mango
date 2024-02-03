package com.itwill.jpa.entity.board;

import java.util.ArrayList;
import java.util.List;

import com.itwill.jpa.dto.board.BoardCategoryDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Table(name = "board_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardCategory {
	@Id
	@SequenceGenerator(name = "BOARD_CATEGORY_NO_SEQ", sequenceName = "BOARD_CATEGORY_NO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_CATEGORY_NO_SEQ")
	@Column(name = "board_category_id" )
	private Long id;
	private String boardCategoryName;

	
	
	public static BoardCategory toEntity(BoardCategoryDto dto) {
		return BoardCategory.builder()
							.id(dto.getId())
							.boardCategoryName(dto.getBoardCategoryName())
							.build();
	}
	
	//1대N관계설정
	@OneToMany(mappedBy = "boardCategory", cascade = CascadeType.PERSIST)
	@Builder.Default
	@ToString.Exclude
	private List<Board> boards = new ArrayList<Board>();


}