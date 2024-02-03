package com.itwill.jpa.repository.cart;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.cart.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
