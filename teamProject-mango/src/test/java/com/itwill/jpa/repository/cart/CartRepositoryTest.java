package com.itwill.jpa.repository.cart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.user.UserRepository;

import jakarta.transaction.Transactional;

class CartRepositoryTest extends TeamProjectMangoApplicationTest {

	@Autowired
	CartRepository cartRepository;
	@Autowired
	CartItemRepository cartItemRepository;
	@Autowired
	UserRepository userRepository;
	
	@Test
	//@Disabled
	@Rollback(false)
	@Transactional
	void saveCartWithUser() {
		Cart cart1 = Cart.builder()
							.cartId(1L)
							.cartTotPrice(0)
							.build();

		User user1=User.builder()
					  .userId("2222")
					  .userAddress("2")
					  .userEmail("2")
					  .userGender("2")
					  .userJumin("2")
					  .userName("2")
					  .userPhone("2")
					  .userPw("2")
					  .build();
		cart1.setUser(user1);
		cartRepository.save(cart1);
		

	}
	
}
