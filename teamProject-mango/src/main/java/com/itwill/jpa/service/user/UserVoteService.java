package com.itwill.jpa.service.user;

import java.util.List;

import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.dto.user.UserUpdateDto;
import com.itwill.jpa.dto.user.UserVoteDto;
import com.itwill.jpa.entity.user.User;

public interface UserVoteService {

	// 유저의 투표번호로 유저정보 조회
	public List<UserDto> findByVote_VoteId(Long voteId);
}
