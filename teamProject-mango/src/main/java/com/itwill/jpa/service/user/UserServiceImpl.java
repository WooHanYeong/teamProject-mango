package com.itwill.jpa.service.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.dao.user.UserDao;
import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.dto.user.UserLoginDto;
import com.itwill.jpa.dto.user.UserUpdateDto;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.user.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public UserDto createUser(UserDto userDto) throws Exception {
		if(userDao.existsById(userDto.getUserId())) {
			throw new Exception(userDto.getUserId() + "는 이미 존재하는 아이디입니다.");
		}
		
		User createdUser = userDao.createUser(User.toEntity(userDto));
		UserDto insertUser = UserDto.toDto(createdUser);
		return insertUser;
	}
	
	@Override
	public User loginUser(String userId, String userPw) throws Exception {
        User user = userDao.loginUser(userId, userPw);

        if (user == null) {
            throw new Exception("아이디 또는 비밀번호가 일치하지 않습니다.");
        }
        return user;
    }

	@Override
	public UserUpdateDto updateUser(UserUpdateDto userUpdateDto) throws Exception {
		// 아이디로 사용자 찾기
		User user = userDao.findUser(userUpdateDto.getUserName());

		if (user == null) {
			throw new Exception("사용자를 찾을 수 없습니다.");
		}

		// UserUpdateDto에서 User 엔터티로 정보 업데이트
		user.setUserPw(userUpdateDto.getUserPw());
		user.setUserName(userUpdateDto.getUserName());
		user.setUserPhone(userUpdateDto.getUserPhone());
		user.setUserAddress(userUpdateDto.getUserAdress());
		user.setUserEmail(userUpdateDto.getUserEmail());

		// 업데이트된 사용자 정보를 저장
		User updatedUser = userDao.updateUser(user);

		return UserUpdateDto.toDto(updatedUser);
	}

	@Override
    public void deleteUser(String userId) throws Exception {
        User user = userDao.findUser(userId);

        if (user == null) {
            throw new Exception("사용자를 찾을 수 없습니다.");
        }
        userDao.deleteUser(userId);
    }

	@Override
    public User findUser(String userId) throws Exception {
        User user = userDao.findUser(userId);

        if (user == null) {
            throw new Exception("사용자를 찾을 수 없습니다.");
        }
        return user;
    }

	@Override
	public List<UserDto> findUserList() {
	    List<User> userList = userDao.findUserList();

	    List<UserDto> userDtoList = new ArrayList<UserDto>();

	    for (User user : userList) {
	        userDtoList.add(UserDto.toDto(user));
	    }
	    return userDtoList;
	}

	@Override
	public boolean existsById(String userId) throws Exception {
		return userDao.existsById(userId);
		
	}

	@Override
	public String findUserIdByUserNameUserEmail(String userName, String userEmail) throws Exception {
	    if (userName == null || userName.isEmpty()) {
	        throw new Exception("사용자 이름이 잘못되었습니다.");
	    }
	    if (userEmail == null || userEmail.isEmpty()) {
	        throw new Exception("사용자 이메일이 잘못되었습니다.");
	    }
	    String userId = userDao.findUserIdByUserNameUserEmail(userName, userEmail);
	    if (userId == null) {
	        throw new Exception("해당 정보로 등록된 사용자가 없습니다.");
	    }
	    return userId;
	}

	@Override
	public String findUserPwByUserIdUserPhone(String userId, String userPhone) throws Exception {
		if (userId == null || userId.isEmpty()) {
			throw new Exception("사용자 아이디가 잘못되었습니다.");
		}
		if (userPhone == null || userPhone.isEmpty()) {
			throw new Exception("사용자 번호가 잘못되었습니다.");
		}

		String userPw = userRepository.findUserPwByUserIdUserPhone(userId, userPhone);
		if (userPw == null) {
			throw new Exception("해당 정보로 등록된 사용자가 없습니다.");
		}
		return userPw;
	}

}
	
	

