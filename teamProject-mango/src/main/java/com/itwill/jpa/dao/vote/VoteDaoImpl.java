package com.itwill.jpa.dao.vote;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.dto.vote.VoteDto;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.repository.vote.VoteRepository;

public class VoteDaoImpl implements VoteDao {

	@Autowired
	VoteRepository voteRepository;

	@Override
	public Vote createVote(Vote vote) throws Exception {
		Vote createVote = voteRepository.save(vote);
		return createVote;
	}

	// 전체 투표 리스트 검색--> 테스트완료
	@Override
	public List<Vote> findVoteListAll() throws Exception {
		List<Vote> findVoteList = voteRepository.findAll();
		return findVoteList;
	}

	// 투표번호로 투표 1개 선택--> 테스트완료
	@Override
	public Vote selectByVoteNo(Long no) throws Exception {
		Optional<Vote> selectByVoteNo = voteRepository.findById(no);
		if (selectByVoteNo.isEmpty()) {
			throw new Exception("존재하지 않는 투표번호입니다.");
		}
		Vote selectedByVoteNo = selectByVoteNo.get();
		return selectedByVoteNo;
	}

	// 투표번호로 투표 삭제 --> 테스트완료
	public void deleteByVoteNo(Long no) throws Exception {
		voteRepository.deleteById(no);
	}

	

}
