package com.itwill.jpa.service.vote;



import java.sql.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.entity.product.Product;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.dao.user.UserDao;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.repository.product.ProductRepository;
import com.itwill.jpa.repository.user.UserRepository;
import com.itwill.jpa.repository.user.UserVoteRepository;
import com.itwill.jpa.repository.vote.VoteRepository;
import com.itwill.jpa.service.product.ProductServiceImpl;
import com.itwill.jpa.service.user.UserService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
@Transactional
class VoteServiceImplTest extends TeamProjectMangoApplicationTest{
	
	@Autowired
	UserVoteRepository userVoteRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Autowired
	UserDao userDao;
	
	
	@PersistenceContext
	EntityManager em;
	
	
	@Autowired
	VoteRepository voteRepository;

	@Autowired
	VoteServiceImpl voteServiceImpl;
	

	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void creatVoteTest() throws Exception {
		Date localDate = new Date(2023);
		
	    Vote vote1 = new Vote(null, localDate, 99, null, null);
	    vote1.setVoteDate(localDate);
	    voteServiceImpl.createVote(vote1);
		/*
		Date localDate = new Date(2023);
		/*Vote vote1 = Vote.builder()
		 		 		 .voteTot(320)
		 		 		 .build(); */
		 /*Vote vote1 = new Vote();
		  vote1.setVoteDate(localDate);
		  vote1.setVoteId(70L);
		  voteServiceImpl.createVote(vote1);
		  */
		  System.out.println("~~~~~~~~~~~~~~~"+voteServiceImpl.createVote(vote1));
		  //vote1.setVoteTot(123);
		  //voteServiceImpl.updateVote(vote1);
		  ///System.out.println("업데이트 완료!!--->"+voteServiceImpl.updateVote(vote1));
		   
	}
	
	@Test
	@Disabled
	void selecteVoteTest() throws Exception {
		System.out.println("@@@@@"+voteServiceImpl.selectByVoteNo(1L));
	
	}
	
	@Test
	@Disabled
	void deleteVoteTest() throws Exception {
	System.out.println("#################-->>"+voteServiceImpl.findVoteListAll().size());		
	System.out.println("#################-->>"+voteServiceImpl.findVoteListAll());		
	voteRepository.deleteById(272L);
	System.out.println("#################-->>"+voteServiceImpl.findVoteListAll().size());
	//System.out.println("@@@@@-->>"+voteServiceImpl.selectByVoteNo(1L));
	
	}	
	
	
	@Test
	@Disabled
	void selectVoteTest() throws Exception {
		// System.out.println("#################-->>"+voteServiceImpl.findVoteListAll().get(1));
		 System.out.println("#################-->>"+voteServiceImpl.findVoteListAll());
		// System.out.println("@@@@@-->>"+voteServiceImpl.selectByVoteNo(1L));
		
		}	
	
	@Transactional
	@Rollback(false)
	@Test
	@Disabled
	public void updateTest() {
		Vote vote1 = Vote.builder()
						 .voteId(1L)
						 .voteTot(320)
						 .build();
		voteServiceImpl.createVote(vote1);

		// User 생성
		User user1 = new User();
		user1.setUserId("vote1");
		user1.setUserPw("vote1");
		user1.setUserName("vote1테스트님");
		user1.setUserPhone("010-1234-5678");
		user1.setVote(vote1);
		userDao.createUser(user1);

		User user2 = new User();
		user2.setUserId("vote2");
		user2.setUserPw("vote2");
		user2.setUserName("vote2테스트님");
		user2.setUserPhone("010-1234-5678");
		user2.setVote(vote1);
		userDao.createUser(user2);

		// product VoteId 수정
		Long product1 = 1L;
		Product product11 = productServiceImpl.getProduct(product1);
		product11.setProductName("수정 테스트완료");
		product11.setVote(vote1);

		Long product2 = 1L;
		Product product = productServiceImpl.getProduct(product2);
		product.setProductName("수정 테스트완료");
		product.setVote(vote1);

		// updateProduct 메서드 호출
		Product updatedProduct = productServiceImpl.updateProduct(product);

		// update

		try {
			voteServiceImpl.updateVote(vote1);
			System.out.println(">>>>"+voteServiceImpl.updateVote(vote1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
