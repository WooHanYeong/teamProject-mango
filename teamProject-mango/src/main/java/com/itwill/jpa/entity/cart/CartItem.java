package com.itwill.jpa.entity.cart;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.entity.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

	@Id
	@SequenceGenerator(name = "CART_ITEM_NO_SEQ", sequenceName = "CART_ITEM_NO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_ITEM_NO_SEQ")
	private Long cartItemId;
	private int cartItemQty;

	/*
	 * @CreationTimestamp private LocalDateTime createAt;
	 * 
	 * @UpdateTimestamp private LocalDateTime updateAt;
	 */

	public static CartItem toEntity(CartItemDto dto) {
		return CartItem.builder().cartItemId(dto.getCartItemId()).cartItemQty(dto.getCartItemQty()).build();
	}

	public static CartItem toEntity(CartItemDto dto, Product product) {
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		// Set other properties from dto
		return cartItem;
	}

	// cartitem -cart설정
	@ManyToOne
	@JoinColumn(name = "cart_no")
	private Cart cart;

	// cartitem -product설정
	@ManyToOne
	@JoinColumn(name = "product_no")
	private Product product;

}
