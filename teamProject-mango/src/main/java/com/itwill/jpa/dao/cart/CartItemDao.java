package com.itwill.jpa.dao.cart;

import java.util.List;


import com.itwill.jpa.entity.cart.CartItem;
public interface CartItemDao {
	
	//cartItem 추가
	//CartItem insert(CartItem cartItem) throws Exception;
	CartItem insertCartItem(CartItem cartItem) throws Exception;
	
	//cartitem 삭제
	void deleteByCartId(Long cartItemId) throws Exception;
	
	//cartitem 업데이트
	CartItem updateByUserId(CartItem cartItem) throws Exception;
	
	CartItem findByCartItemId(Long cartItemId) throws Exception;
}
