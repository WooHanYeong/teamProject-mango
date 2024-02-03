package com.itwill.jpa.dao.order;

import java.util.List;

import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.order.OrderItem;

public interface OrderItemDao {

	OrderItem insertOrderItem(OrderItem orderItem);
	
	OrderItem selectOrderItem(Long orderItemId);
	
	List<OrderItem> orderItems(Long orderId);
	
	List<OrderItem> orderItems(String userId);
	
	OrderItem updateOrderItem(OrderItem orderItem);
	
	void deleteOrderItem(Long orderItemId);
	
	void deleteAll();
	
}
