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
public class UserUpdateDto {
	 
	private String userPw;
	private String userName;
	private String userPhone;
	private String userAdress;
	private String userEmail;
	
	public static UserUpdateDto toDto(User entity) {
		return UserUpdateDto.builder()
							.userPw(entity.getUserPw())
							.userName(entity.getUserName())
							.userPhone(entity.getUserPhone())
							.userAdress(entity.getUserAddress())
							.userEmail(entity.getUserEmail())
							.build();
	}
	
	
}

