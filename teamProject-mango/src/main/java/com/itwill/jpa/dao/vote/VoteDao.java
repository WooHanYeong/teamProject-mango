package com.itwill.jpa.dao.vote;

import java.util.List;

import com.itwill.jpa.dto.vote.VoteDto;
import com.itwill.jpa.entity.vote.Vote;

public interface VoteDao {

	// 투표 생성
	Vote createVote(Vote vote) throws Exception;

	// 전체 투표 리스트 검색
	List<Vote> findVoteListAll() throws Exception;

	// 투표번호로 투표 1개 선택
	Vote selectByVoteNo(Long no) throws Exception;

	// 투표번호로 투표 1개 삭제
	void deleteByVoteNo(Long no) throws Exception;

	/* 투표 업데이트 --> 구현 안하기로 함
	   Vote updateVote(Vote vote) throws Exception;
	*/

}
