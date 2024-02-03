package com.itwill.jpa.service.cart;

import java.util.List;
import java.util.Optional;

import com.itwill.jpa.dto.cart.CartDto;
import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.user.User;

public interface CartService {
	//장바구니 생성
	public CartDto createCart(CartDto cartDto) throws Exception;
	
	//장바구니 전체 비우기
	public CartDto deleteAllByCartId(Long cartId) throws Exception;
	
	//총합 계산
	public CartDto calculateTotalPrice(List<CartItemDto> cartItemDtos) throws Exception;
	
	//장바구니 조회
	//public CartDto getCartItems(List<CartItemDto> cartItemDtos) throws Exception;
	
	//장바구니 추가
	//public Cart insert(Cart cart) throws Exception;
	
	//장바구니 비우기
	//public void deleteAllByCartId(Long cartId) throws Exception;
	
	//총합 계산
	//public int calculateTotalPrice(List<CartItem> cartItems) throws Exception;
	
	//장바구니 조회
	//List<Cart> getCartItems(Cart cart) throws Exception;
	


	
	
	
	
}
