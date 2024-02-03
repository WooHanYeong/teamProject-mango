package com.itwill.jpa.exception.order;

public class OrderItemNotFoundException extends IllegalStateException{

	public OrderItemNotFoundException(String message) {
		super(message);
	}
	
}
