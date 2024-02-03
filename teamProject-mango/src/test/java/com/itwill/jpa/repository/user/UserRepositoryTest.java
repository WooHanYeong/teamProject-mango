package com.itwill.jpa.repository.user;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.cart.CartRepository;

class UserRepositoryTest extends TeamProjectMangoApplicationTest {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	CartRepository cartRepository;

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("회원가입")
	   void testSave() {
	      User user1 = User.builder()
	                   .userId("kbs")
	                   .userPw("1111")
	                   .userName("고범석")
	                   .userAddress("서울시 강남")
	                   .userEmail("kbs@naver.com")
	                   .userJumin("970000-0000000")
	                   .userPhone("010-1234-5678")
	                   .userGender("남")
	                   .build();
	      
	      User user2 = User.builder()
                 .userId("zzz")
                 .userPw("2222")
                 .userName("zzz")
                 .userAddress("zzz")
                 .userEmail("zzz@naver.com")
                 .userJumin("000000-0000000")
                 .userPhone("011-1234-5678")
                 .userGender("여")
                 .build();
	      
			/*
			 * Cart cart = Cart.builder() .cartId(1L) .build();
			 */
	      
	      System.out.println(">>> " + user1);
	      userRepository.save(user1);
	      


		//cartRepository.save(cart);
		userRepository.save(user1);
		userRepository.save(user2);
	}
}
