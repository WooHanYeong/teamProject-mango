package com.itwill.jpa.repository.cart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.product.ProductRepository;

import jakarta.transaction.Transactional;

class CartItemRepositoryTest extends TeamProjectMangoApplicationTest{
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CartRepository cartRepository;
	

	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	void saveCartItemsWithCart() {
		CartItem cartItem1 = CartItem.builder()
										.cartItemId(1L)
										.cartItemQty(5)
										.build();
		
		Cart cart1 = Cart.builder()
							.cartId(1L)
							.build();
		
		
		Product product1 = Product.builder()
									.productNo(1L)
									.productAddress(null)
									.productArtist(null)
									.productContent(null)
									.productDate(null)
									.productImage(null)
									.productMovie(null)
									.productName(null)
									.productPrice(0)
									.productReply(null)
									.productStock(0)
									.productCategory(null)
									.build();
		
		cartItem1.setCart(cart1);
		cartItem1.setProduct(product1);
		cartItemRepository.save(cartItem1);
		
		
		
		
	}
	
	
}
