package com.itwill.jpa.service.cart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.cart.CartItemRepository;
import com.itwill.jpa.repository.cart.CartRepository;
import com.itwill.jpa.repository.user.UserRepository;

import jakarta.transaction.Transactional;

class CartItemServiceImplTest extends TeamProjectMangoApplicationTest {

	@Autowired
	CartItemServiceImpl cartItemServiceImpl;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void cartItemInsert() throws Exception{
		Optional<Cart> cart = cartRepository.findById(2L);
		System.out.println("cart>>>>>>>>>>>"+cart);
		//CartItemDto cartItem1 = CartItem.builder().cartItemId(0L).cartItemQty(10).cart(cart.get()).productId(1L).build();
		//CartItem cartItem2 = CartItem.builder().cartItemId(0L).cartItemQty(15).cart(cart.get()).productId(2L).build();
		//CartItem cartItem3 = CartItem.builder().cartItemId(0L).cartItemQty(16).cart(cart.get()).productId(3L).build();
		//cartItemServiceImpl.insert(cartItem1);
	    CartItemDto cartItemDto1 = new CartItemDto();
	    cartItemDto1.setCartItemQty(10);
	    Product product1 = new Product();
	    product1.setProductNo(1L);
	    cartItemDto1.setProductId(product1.getProductNo());
	    cartItemDto1.setCartId(cart.get().getCartId());
	   /*
	    CartItemDto cartItemDto2 = new CartItemDto();
	    cartItemDto2.setCartItemQty(15);
	    cartItemDto2.getProduct().setProductNo(2L);
	    cartItemDto2.setCartId(cart.get().getCartId());
	    CartItemDto cartItemDto3 = new CartItemDto();
	    cartItemDto3.setCartItemQty(16);
	    cartItemDto3.getProduct().setProductNo(3L);
	    cartItemDto3.setCartId(cart.get().getCartId());
	    */
	    cartItemServiceImpl.insert(cartItemDto1);
	    //cartItemServiceImpl.insert(cartItemDto2);
	    //cartItemServiceImpl.insert(cartItemDto3);
	    System.out.println("cartItemDto1>>>>>>>>>>>>>>>>"+cartItemDto1);
	}
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void deleteByCartItemId() throws Exception {
		cartItemServiceImpl.deleteByCartItemId(25L);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void updateCartItemsQty() throws Exception {
		Long cartItemId = 4L;
		int updateQty = 100;
		cartItemServiceImpl.update(cartItemId, updateQty);
		
	}

}
