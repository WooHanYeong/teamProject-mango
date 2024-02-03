package com.itwill.jpa.dto.user;

import com.itwill.jpa.entity.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserLoginDto {

	private String UserId;
	private String UserPw;
	
	public static UserLoginDto toDto(User entity) {
		return UserLoginDto.builder()
						   .UserId(entity.getUserId())
						   .UserPw(entity.getUserPw())
						   .build();
	}
	
}


