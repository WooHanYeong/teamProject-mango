package com.itwill.jpa.service.board;

import java.time.LocalDateTime;
import java.util.List;

import com.itwill.jpa.entity.board.Board;
import com.itwill.jpa.entity.board.BoardType;
import com.itwill.jpa.entity.user.User;

public interface BoardService {
	
	//등록
	public Board insert(Board board);
	
	//삭제
	public void delete(Long boardId);
	
	//업데이트
	public Board update(Board board);
	
	//category별 분류
	public List<Board> findBycategory(Long id);
	
	public List<Board> findByType(Long id);
	
//	// 조회수 올리기
//	public Board increaseReadCount(Board board);
	
//	//조회수정렬
//	public List<Board> getBoardsOrderByReadCount();
//
//	//좋아요 누르면 올라가기 (내려가기)
//    public void incrementLikeCount(Long boardId);
    
	//키워드로 검색 
    public List<Board> searchBoardsByKeyword(String keyword);
    
    //최근일주일,한달,등 시간으로 검색
    public List<Board> searchBoardsByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    public List<Board> findAllByOrderByBoardReadCountDesc();

    public List<BoardType> findAllByOrderByTypeIdAsc();

    public List<Board> findByBoardCategory_IdAndUser_UserIdOrderByCreatedTime(Long boardCategoryId, String userId);
    
    
}