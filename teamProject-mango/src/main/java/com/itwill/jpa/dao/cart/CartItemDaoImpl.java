package com.itwill.jpa.dao.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.repository.cart.CartItemRepository;
@Repository
public class CartItemDaoImpl implements CartItemDao{
	
	@Autowired
	CartItemRepository cartItemRepository;
	/*	
	@Override
	public CartItem insert(CartItem cartItem) throws Exception {
		CartItem insertCart = cartItemRepository.save(cartItem);
		return insertCart;
	}
	 */
    @Override
    public CartItem insertCartItem(CartItem cartItem) throws Exception {
        return cartItemRepository.save(cartItem);
    }
    
	@Override
	public void deleteByCartId(Long cartItemId) throws Exception {
		try {
			cartItemRepository.deleteById(cartItemId);
		} catch (Exception e) {
			throw new Exception("error");
		}
	}

	@Override
	public CartItem updateByUserId(CartItem updateCartItem) throws Exception {
		Optional<CartItem> findCartOptional = cartItemRepository.findById(updateCartItem.getCartItemId());
		CartItem updatedCart = null;
		if (findCartOptional.isPresent()) {
			CartItem cartItem = findCartOptional.get();
			cartItem.setCartItemQty(updateCartItem.getCartItemQty());
			updatedCart = cartItemRepository.save(cartItem);
		}else {
			throw new Exception("존재하지 않는 장바구니입니다.");
		}
		return updatedCart;
	}

	@Override
	public CartItem findByCartItemId(Long cartItemId) throws Exception {
		CartItem findCartItem = cartItemRepository.findById(cartItemId).get();
		return findCartItem;
	}

}
