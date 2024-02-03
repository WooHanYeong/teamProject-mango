package com.itwill.jpa.repository.board;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.board.Board;
import com.itwill.jpa.entity.board.BoardCategory;
import com.itwill.jpa.entity.board.BoardType;

class BoardRepositoryTest extends TeamProjectMangoApplicationTest{
	
	@Autowired
	BoardRepository boardRepository;
	@Autowired
	BoardCategoryRepository boardCategoryRepository;
	@Autowired
	BoardTypeRepository boardTypeRepository;

//	@Test
//	@Transactional
//	@Rollback(false)
//	//@Disabled
//	void userBoardTest() {
//        String username = "우한영"; // 테스트할 사용자 이름을 지정
//
//        List<Board> boards = boardRepository.findBoardsByUsername(username);
//        System.out.println("우한영이 가지고있는 문의글은?"+boards);
//	}    
	
	
//	@Test
//	@Transactional
//	@Rollback(false)
//	//@Disabled
//	void boardSaveTest() {
//		
//		BoardCategory boardCategory= BoardCategory.builder()
//			.id(2L)
//			.boardCategoryName("이벤트")
//			.build();
//		
//		BoardType boardType= BoardType.builder()
//									  .typeId(1L)
//									  .boardTypeTitle("기타")
//									  .build();
//		
//		Board board = Board.builder()
//						   .boardId(null)
//						   .boardTitle("boardTest")
//						   .boardContent("테스트중입니다")
//						   .boardReadCount(999)
//						   .boardPrize("에어팟")
//						   .boardImage("uploads/image1")
//						   .build();
//		
//		
//		board.setBoardCategory(boardCategory);
//		board.setBoardType(boardType);
//		boardCategoryRepository.save(boardCategory);
//		boardTypeRepository.save(boardType);
//		boardRepository.save(board);
//		
//
//	}
//	
//	@Test
//	@Transactional
//	@Rollback(false)
//	//@Disabled
//	void findAll() {
//	    List<Board> boards = boardRepository.findAll();
//	    for (Board board : boards) {
//	        System.err.println("Board Title 은 무엇?: " + board.getBoardTitle());
//	    }
//	}
//	
//	@Test
//	@Transactional
//	@Rollback(false)
//	//@Disabled
//	void findByCategoryId() {
//		List<Board> boards = boardRepository.findByBoardCategory_IdOrderByCreatedTime(2L);
//		System.out.println("CATEGORY : 2L >>>>>>>>>>"+boards);
//	}
//	
//	@Test
//	@Transactional
//	@Rollback(false)
//	//@Disabled
//	void findByTypeId() {
//		List<Board> boards =boardRepository.findByBoardType_TypeIdOrderByCreatedTime(1L);
//		System.out.println("TYPE : 1L ???????????????"+boards);
//		
//	}
	
}
