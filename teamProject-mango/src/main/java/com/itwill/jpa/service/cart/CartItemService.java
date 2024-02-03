package com.itwill.jpa.service.cart;

import java.util.List;

import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.entity.cart.CartItem;

public interface CartItemService {
	

	//상품 추가
	public CartItemDto insert(CartItemDto dto) throws Exception;
	
	//수량 수정
	public CartItemDto update(Long cartItemId, int qty) throws Exception;
	
	//상품 삭제
	public void deleteByCartItemId(Long cartItemId) throws Exception;
	
	//장바구니에 담긴 모든 상품
	public List<CartItemDto> findAll();
		
	
}
