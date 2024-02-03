package com.itwill.jpa.dto.user;

import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.entity.vote.Vote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVoteDto {	 

	private String userId;			// 회원 아이디
	private String userPw;			// 회원 비밀번호
	private String userName;		// 회원 이름
	private Vote vote;
	
	public static UserVoteDto toDto(User entity) {
		return UserVoteDto.builder()
				  .userId(entity.getUserId())
				  .userPw(entity.getUserPw())
				  .userName(entity.getUserName())
				  .vote(entity.getVote())
				  .build();
	}
}
