package com.itwill.jpa.dao.user;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.itwill.jpa.dto.user.UserUpdateDto;
import com.itwill.jpa.dto.user.UserVoteDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;

public interface UserVoteDao {

	// 유저의 투표번호로 투표와 유저정보 조회
	User findUserVoteId(Long voteId);
	

}
