package com.itwill.jpa.dao.board;

import java.util.List;

import com.itwill.jpa.entity.board.Board;

public interface BoardDao {
	
	Board insertBoard(Board board);
	
	Board selectBoard(Long no);
	
	Board updateBoard(Board board) throws Exception;
	
	void deleteBoard(Long no) throws Exception;
	
	List<Board> selectList();
	
}
