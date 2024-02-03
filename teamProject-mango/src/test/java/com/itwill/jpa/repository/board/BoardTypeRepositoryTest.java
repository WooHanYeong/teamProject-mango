package com.itwill.jpa.repository.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.board.BoardType;

class BoardTypeRepositoryTest extends TeamProjectMangoApplicationTest{

	@Autowired
	BoardTypeRepository boardTypeRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void boardTypeList() {
		 List<BoardType> boardTypeList= boardTypeRepository.findAllByOrderByTypeIdAsc();
		 System.out.println("리스트: >>>>>>"+boardTypeList);
	}

}
