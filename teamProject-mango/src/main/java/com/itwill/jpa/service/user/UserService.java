package com.itwill.jpa.service.user;

import java.util.List;

import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.dto.user.UserLoginDto;
import com.itwill.jpa.dto.user.UserUpdateDto;
import com.itwill.jpa.entity.user.User;

public interface UserService {

	// 회원가입
	UserDto createUser(UserDto userDto) throws Exception;

	// 로그인
	User loginUser(String userId, String userPw) throws Exception;

	// 회원 정보 업데이트
	UserUpdateDto updateUser(UserUpdateDto userUpdateDto) throws Exception;

	// 회원 탈퇴
	void deleteUser(String userId) throws Exception;

	// 회원 상세 정보 조회
	User findUser(String userId) throws Exception;

	// 전체 회원 목록 조회
	List<UserDto> findUserList() throws Exception;

	// 아이디 중복 체크
	boolean existsById(String userId) throws Exception;

	// 이메일, 이름으로 아이디 찾기
	String findUserIdByUserNameUserEmail(String userName, String userEmail) throws Exception;

	// 아이디, 번호로 비밀번호 찾기
	String findUserPwByUserIdUserPhone(String userId, String userPhone) throws Exception;


}
