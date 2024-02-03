package com.itwill.jpa.controller.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.service.cart.CartItemService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class CartItemRestController {
	
    @Autowired
    private CartItemService cartItemService;
    @Operation(summary = "장바구니에 상품추가")
    @PostMapping("/insert")
    public String insertCartItem(CartItemDto dto, Model model) {
    	CartItemDto insertCartItem;
        try {
        	insertCartItem = cartItemService.insert(dto);
        	model.addAttribute("inserCartItem",insertCartItem);
        	return "성공";
        } catch (Exception e) {
        	e.printStackTrace();
            return "실패";
        }
    }
    @Operation(summary = "수량 업데이트")
    @PostMapping("/update")
    public String updateCartItem(CartItemDto dto,Model model) {
    	CartItemDto updateCartItem;
    	try {
			updateCartItem = cartItemService.update(dto.getCartItemId(), dto.getCartItemQty());
			model.addAttribute("updateCartItem",updateCartItem);
			return "성공";
		} catch (Exception e) {
			e.printStackTrace();
			return "실패";
		}
    }
    
    @Operation(summary = "상품 한개 삭제")
    @DeleteMapping("/cartItem/{cartItemId}")
    public String deleteCartItem(@PathVariable(value = "cartItemId") Long CartItemId) {
    	try {
			cartItemService.deleteByCartItemId(CartItemId);
			return "삭제성공";
		} catch (Exception e) {
			e.printStackTrace();
			return "삭제실패";
		}
    	
    }
    
    
}
