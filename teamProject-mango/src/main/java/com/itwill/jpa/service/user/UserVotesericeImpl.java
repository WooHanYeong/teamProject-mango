package com.itwill.jpa.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.dto.user.UserVoteDto;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.user.UserRepository;

public class UserVotesericeImpl implements UserVoteService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<UserDto> findByVote_VoteId(Long voteId) {
	/*	List<User> userList = userRepository.findByVote_VoteId(voteId);
	    List<UserDto> userDtos = new ArrayList<>();

	    for (User user : userList) {
	        UserDto userDto = UserDto.toDto(user);
	        userDtos.add(userDto);
	    }
	    
	    return userDtos;
	*/
		return null;
	}
	

}
