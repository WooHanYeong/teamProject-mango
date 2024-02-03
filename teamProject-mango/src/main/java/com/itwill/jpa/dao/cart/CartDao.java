package com.itwill.jpa.dao.cart;

import java.util.List;

import com.itwill.jpa.dto.cart.CartDto;
import com.itwill.jpa.entity.cart.Cart;

public interface CartDao {
	
	//새로운 카트 생성
	void createCart(Cart cart) throws Exception;
	
	//장바구니에 담긴 상품 수
	//int cartRowCount(String userId) throws Exception;
	
	//cartId로 카트 정보 조회
	Cart getCartById(Long cartId) throws Exception;
	
	//cartId로 장바구니에 담긴 상품들 모두삭제
	//void deleteAllByCartId(Long cartId) throws Exception;
	
	//모든 카트리스트 조회
	List<Cart> findAllCartList() throws Exception;
	
	Cart findByCartId(Long cartId) throws Exception;
	

}
