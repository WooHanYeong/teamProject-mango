package com.itwill.jpa.service.order;

import java.util.List;

import com.itwill.jpa.dto.order.OrderItemDto;

public interface OrderItemService {

	OrderItemDto saveOrderItem(OrderItemDto orderItem);
	
	OrderItemDto updateOrderItem(OrderItemDto orderItem);
	
	OrderItemDto deleteOrderItem(Long id) throws Exception;
	
	List<OrderItemDto> deleteAllOrderItem() throws Exception;
	
	List<OrderItemDto> orderItemsByOrderId(Long orderId);
	
	
	List<OrderItemDto> orderItemsByUserId(String userId);
	
	OrderItemDto findOrderItem(Long id);


}