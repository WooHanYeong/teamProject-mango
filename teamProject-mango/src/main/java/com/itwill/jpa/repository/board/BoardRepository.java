package com.itwill.jpa.repository.board;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.jpa.entity.board.Board;

public interface BoardRepository extends JpaRepository<Board,Long >{

	List<Board> findAll();
	
	//카테고리ID로 분류하기
	List<Board> findByBoardCategory_IdOrderByCreatedTime(Long boardcategoryid);
	
	//타입ID로 분류하기
	List<Board> findByBoardType_TypeIdOrderByCreatedTime(Long boardTypeId);
	
	//보드카테고리 and 유저아이디로 찾기
	List<Board> findByBoardCategory_IdAndUser_UserIdOrderByCreatedTime(Long boardCategoryId, String userId);

	
	//keyword가 포함된 title찾기 
    List<Board> findByBoardTitleContaining(String keyword);
    
    //기간으로 찾기 
    List<Board> findByCreatedTimeBetween(LocalDateTime startDate, LocalDateTime endDate);

    // boardCount 필드로 내림차순 정렬
    List<Board> findAllByOrderByBoardReadCountDesc();
    
//
//    @Query("SELECT b FROM Board b WHERE b.id IN (SELECT ub.board.id FROM UserBoard ub WHERE ub.user.username = :username)")
//    List<Board> findBoardsByUsername(String username);



}
