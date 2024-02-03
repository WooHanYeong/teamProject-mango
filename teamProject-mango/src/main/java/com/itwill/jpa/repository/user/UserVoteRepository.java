package com.itwill.jpa.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itwill.jpa.entity.vote.Vote;

public interface UserVoteRepository extends JpaRepository<Vote, Long>{

	// 유저의 투표번호로 투표와 유저정보 조회
	@Query(value = "SELECT * FROM userinfo u JOIN vote v ON u.vote_id = v.vote_id WHERE u.vote_id = :voteId", nativeQuery = true)
	String findUserVoteId(@Param("voteId") Long voteId);
	
	
	// 유저의 투표번호로 투표,상품전체조회
	@Query(value = "SELECT u.*, p.*, v.* FROM product p INNER JOIN userinfo u ON p.vote_id = u.vote_id INNER JOIN vote v ON u.vote_id = v.vote_id WHERE p.vote_id = :voteId", nativeQuery = true)
	String findUserVoteIdWithProduct(@Param("voteId") Long voteId);
}
