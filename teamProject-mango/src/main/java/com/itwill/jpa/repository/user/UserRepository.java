package com.itwill.jpa.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	  @Query(value = "SELECT u.user_id FROM userinfo u WHERE u.user_name = :user_name and u.user_email = :user_email", nativeQuery = true)
	  String findUserIdByUserNameUserEmail(@Param("user_name") String userName, @Param("user_email") String userEmail);
	  
	  @Query(value = "SELECT u.user_pw FROM userinfo u WHERE u.user_id = :user_id and u.user_phone = :user_phone", nativeQuery = true)
	  String findUserPwByUserIdUserPhone(@Param("user_id") String userId , @Param("user_phone") String userPhone);
	 
	  //public  User findByUsername(String username);
	  
	  // 유저의 투표번호로 유저정보 조회
	  List<User> findByVote_VoteId(Long voteId);
	  
}