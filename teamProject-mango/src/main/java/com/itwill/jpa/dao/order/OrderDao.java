package com.itwill.jpa.dao.order;

import java.util.List;

import com.itwill.jpa.entity.order.Order;

public interface OrderDao {

		Order insertOrder(Order order);
		
		Order selectOrder(Long orderId);
		
		// 관리자(admin)가 주문상태 변경 수정 가능 (ex.결제완료, 배송준비중, 배송완료 등)
		Order updateOrder(Order order) throws Exception;
		
		void deleteOrder(Long orderId) throws Exception;
		
		List<Order> getOrdersByUserId(String userId);
		
		List<Order> selectList();
				
		List<Order> orderListByNewer(String userId);
		
		List<Order> orderListByOlder(String userId);
}
