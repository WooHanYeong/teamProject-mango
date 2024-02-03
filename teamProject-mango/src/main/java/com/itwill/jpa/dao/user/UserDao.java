package com.itwill.jpa.dao.user;

import java.util.List;

import com.itwill.jpa.entity.user.User;

public interface UserDao {

	User createUser(User user);
	
	User loginUser(String userId, String userPw) throws Exception;

    User updateUser(User user) throws Exception;

    void deleteUser(String userId) throws Exception;

    User findUser(String userId);

    List<User> findUserList();
    
    boolean existsById(String userId); //중복된 아이디 체크
    
    String findUserIdByUserNameUserEmail(String userName ,String userEmail); // 이름과 이메일로 아이디 찾기

    String findUserPwByUserIdUserPhone(String userId ,String userPhone); // 아이디와 번호로 비밀번호 찾기
    
    
    
    
}