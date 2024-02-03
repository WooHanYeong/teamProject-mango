package com.itwill.jpa.dao.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dto.user.UserVoteDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.repository.product.ProductRepository;

import com.itwill.jpa.repository.user.UserVoteRepository;
import com.itwill.jpa.repository.vote.VoteRepository;
import com.itwill.jpa.service.product.ProductServiceImpl;
import com.itwill.jpa.service.vote.VoteServiceImpl;

@Repository
@Service
public class UserVoteDaoImpl implements UserVoteDao{

	
	@Autowired 
	VoteServiceImpl voteServiceImpl;

	@Override
	public User findUserVoteId(Long voteId) {
		// TODO Auto-generated method stub
		return null;
	}
}