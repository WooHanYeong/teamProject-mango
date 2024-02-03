package com.itwill.jpa.service.cart;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.dao.cart.CartDaoImpl;
import com.itwill.jpa.dto.cart.CartDto;
import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.cart.CartItemRepository;
import com.itwill.jpa.repository.cart.CartRepository;
import com.itwill.jpa.repository.product.ProductRepository;
import com.itwill.jpa.repository.user.UserRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

class CartServiceImplTest extends TeamProjectMangoApplicationTest {
	@Autowired
	CartServiceImpl cartServiceImpl;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CartItemRepository cartItemRepository;
	@Autowired
	CartRepository cartRepository;

	
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void createCart() throws Exception {
		
		Optional<User> findUser = userRepository.findById("lsg33");
		System.out.println("findUser>>>>>>>>>>>>>>>"+findUser);
		if (findUser.isPresent()) {
			User user = findUser.get();
			System.out.println("user>>>>>>>>>>>>>>>>>>"+user);
			CartDto cartDto = new CartDto();
			cartDto.setCartId(0L);
			cartDto.setUserId(user.getUserId());
			cartDto.setCartTotPrice(10);
			System.out.println("cart1>>>>>>>>>>>>>>>>"+cartDto);
			CartDto createCart = cartServiceImpl.createCart(cartDto);
			System.out.println("insert>>>>>>>>>>>>>>>>>>>>>"+createCart);
		}

	}
	
	
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void cartDelete() throws Exception {
		Optional<Cart> findCart = cartRepository.findById(1L);
		System.out.println("findCart>>>>>>>>>>>>>>"+findCart);
	    if (findCart.isPresent()) {
	        Cart cart = findCart.get();
	        cartServiceImpl.deleteAllByCartId(cart.getCartId());
	    }
	}
	

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void calTotPrice() throws Exception {
		Optional<Cart> findCart = cartRepository.findById(1L);
		 if (findCart.isPresent()) {
		        Cart cart = findCart.get();
		        List<CartItem> cartItems = cart.getCartitems();
		        List<CartItemDto> cartItemDtos = cartItems.stream().map(CartItemDto::toDto).collect(Collectors.toList());
		        CartDto totalPriceDto = cartServiceImpl.calculateTotalPrice(cartItemDtos);
		        cart.setCartTotPrice(totalPriceDto.getCartTotPrice());
		        cartRepository.save(cart);
		        System.out.println("totalprice>>>>>>>>>>"+totalPriceDto);
		        System.out.println("cart>>>>>>>>>>>>"+cart);
		 }
	}
	/*
	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	void getCartItems() throws Exception {
		Cart findCart = cartRepository.findById(2L).orElse(null);
		CartDto toDto = CartDto.toDto(findCart); 
		List<CartDto> dtos = cartServiceImpl.getCartItems(toDto);
		System.out.println("find>>>>>>>>>>"+findCart);
		System.out.println("cartItems>>>>>>>>>>"+dtos);
	}
	*/
}