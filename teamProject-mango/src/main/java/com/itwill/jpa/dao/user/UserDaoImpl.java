package com.itwill.jpa.dao.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.user.UserRepository;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		User createdUser = userRepository.save(user);
		return createdUser;
	}
	
	@Override
	public User loginUser(String userId, String userPw) throws Exception {
		Optional<User> selectedUserOptional = userRepository.findById(userId);

	    if (selectedUserOptional.isPresent()) {
	        User selectedUser = selectedUserOptional.get();
	        if (selectedUser.getUserPw().equals(userPw)) {
	            return selectedUser;
	        }
	    }
	    return null;
	}

	@Override
	public User updateUser(User user) {
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		Optional<User> selectedUserOptional = userRepository.findById(userId);
		userRepository.delete(selectedUserOptional.get());
	}

	@Override
	public User findUser(String userId) {
		User findedUser = userRepository.findById(userId).get();  
		return findedUser;
	}

	@Override
	public List<User> findUserList() {    
		return userRepository.findAll();
	}

	@Override
	public boolean existsById(String userId) {
		return userRepository.existsById(userId);
	}

	@Override
	public String findUserIdByUserNameUserEmail(String userName ,String userEmail) {
		String findId = userRepository.findUserIdByUserNameUserEmail(userName ,userEmail);
		return findId;
	}

	@Override
	public String findUserPwByUserIdUserPhone(String userId, String userPhone) {
		String findPw = userRepository.findUserPwByUserIdUserPhone(userId, userPhone);
		return findPw;
	}

	


}