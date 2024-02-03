package com.itwill.jpa.service.vote;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dto.vote.VoteDto;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.repository.user.UserRepository;
import com.itwill.jpa.repository.vote.VoteRepository;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	VoteRepository voteRepository;
	
	@Autowired
	UserRepository userRepository;	

	// 투표 생성 -->  테스트 /컨트롤러 완료
	@Override
	public Vote createVote(Vote vote) {
	
		return voteRepository.save(vote);
	}
	
	// 전체 투표 리스트 검색-->  테스트 /컨트롤러 완료
	@Override
	public List<Vote> findVoteListAll() throws Exception {
		List<Vote> findVoteList = voteRepository.findAll();
		return findVoteList;
	}
	
	//투표번호로 투표 1개 선택-->  테스트 /컨트롤러 완료
	@Override
	public Vote selectByVoteNo(Long no) throws Exception {
		Optional<Vote> selectByVoteNo = voteRepository.findById(no);
		if (selectByVoteNo.isEmpty()) {
			throw new Exception("존재하지 않는 투표번호입니다.");
		}
		Vote selectedByVoteNo = selectByVoteNo.get();
		return selectedByVoteNo;
	}
	
	// 투표번호로 투표 삭제 -->  테스트 /컨트롤러 완료
	public void deleteByVoteNo(Long no) throws Exception {
	    voteRepository.deleteById(no);
	}
	
	
	//투표 업데이트--> 테스트 / 컨트롤러 완료 
		@Override
		public Vote updateVote(Vote vote) throws Exception {
			
			Vote updateByVoteNo = voteRepository.findById(vote.getVoteId()).orElse(null);
		    if (updateByVoteNo != null) {
		        // User 전체리스트 가져오기
		        List<User> users = userRepository.findAll();
		        
		        // User의 전체 투표수 합산
		        int totalVoteCount = 0;
		        
		        // 사용자 목록(users)를 순회하며 특정 vote 번호와 동일한 사용자의 투표 ID를 합산
		        for (User user : users) {
		            if (user.getVote() != null && user.getVote().getVoteId() == vote.getVoteId()) {
		                totalVoteCount += user.getVote().getVoteId();
		            }
		        }
		        
		        // 전체 투표수를 투표 객체의 투표 총수(voteTot)로 업데이트
		        updateByVoteNo.setVoteTot(totalVoteCount);
		        
		        // 업데이트된 투표 객체 저장
		        return voteRepository.save(updateByVoteNo);
			}else {
				throw new Exception("존재하지 않는 투표번호입니다.");
			}
			
		}
	
}
