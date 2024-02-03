package com.itwill.jpa.service.vote;

import java.util.List;

import com.itwill.jpa.dto.vote.VoteDto;
import com.itwill.jpa.entity.vote.Vote;

public interface VoteService {
		// 투표 생성
		Vote createVote(Vote vote) throws Exception;
		
		//전체 투표 리스트 검색
		List<Vote> findVoteListAll() throws Exception;
		
		//투표번호로 투표 1개 선택
		Vote selectByVoteNo(Long no) throws Exception;
		
		//투표번호로 투표 1개 삭제
		void deleteByVoteNo(Long no) throws Exception;

		//투표 업데이트---> 투표 전체 합 수정 필요!!(실시간 업데이트해야함)
		Vote updateVote(Vote vote) throws Exception;
}
