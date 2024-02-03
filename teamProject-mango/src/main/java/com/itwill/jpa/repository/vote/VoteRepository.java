package com.itwill.jpa.repository.vote;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itwill.jpa.dto.vote.VoteDto;
import com.itwill.jpa.entity.vote.Vote;



public interface VoteRepository extends JpaRepository<Vote, Long>{

//	// 투표 번호로 찾기
//	List<Vote> findByVoteNo(Long voteNo);
//	
//	// 회원아이디로 찾기
//	List<Vote> findByUserId(String userId);
//	
//	// 회원아이디로 찾기
//	List<Vote> findByProductName(String productName);
	
}
