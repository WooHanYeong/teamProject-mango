package com.itwill.jpa.repository.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

	 //List<CartItem> getCartItemsByUserId(String userId);

//	 void deleteByUserIdAndCartItemId(String userId, Long cartItemId);

}
