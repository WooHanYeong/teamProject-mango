package com.itwill.jpa.exception.product;

public class NotEnoughProductStockException extends RuntimeException{

	public NotEnoughProductStockException() {
		super();
	}
	
	public NotEnoughProductStockException(String message) {
		super(message);
	}
	
	public NotEnoughProductStockException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NotEnoughProductStockException(Throwable cause) {
		super(cause);
	}
	
}
