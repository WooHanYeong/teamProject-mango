package com.itwill.jpa.dao.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.dto.cart.CartDto;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.repository.cart.CartItemRepository;
import com.itwill.jpa.repository.cart.CartRepository;
@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
	CartRepository cartRepository;

	@Autowired
	CartItemRepository cartItemRepository;
	@Override
	public void createCart(Cart cart) throws Exception {
		cartRepository.save(cart);
	}

	/*
	@Override
	public void deleteAllByCartId(Long cartId) throws Exception {
		Cart cart = cartRepository.findById(cartId).orElse(null);
		if (cart != null) {
	        cart.getCartitems().clear();
	        cartRepository.save(cart);
	    }
	}
*/
	@Override
	public List<Cart> findAllCartList() throws Exception {
		return cartRepository.findAll();
	}

	@Override
	public Cart getCartById(Long cartId) throws Exception {
		Optional<Cart> findCartOptional = cartRepository.findById(cartId);
		if (findCartOptional.isPresent()) {
	        return findCartOptional.get();
		} else {
		    throw new Exception("존재하지 않는 장바구니입니다.");
		}
		
		
	}
/*
	@Override
	public int cartRowCount(String userId) throws Exception {
		try {
			List<CartItem> cartItems = cartItemRepository.getCartItemsByUserId(userId);
			int totalQty = 0;
			
			for (CartItem cartItem : cartItems) {
				totalQty += cartItem.getCartItemQty();
			}
			return totalQty;	
		}catch (Exception e) {
			throw new Exception("장바구니 상품 수 조회 중 오류 발생",e);
		}	
*/

	@Override
	public Cart findByCartId(Long cartId) throws Exception {
		Cart findCart = cartRepository.findById(cartId).get();
		return findCart;
	}
	
	
	
	
	
}
