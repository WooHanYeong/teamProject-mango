package com.itwill.jpa.dao.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.order.OrderRepository;

import com.itwill.jpa.repository.user.UserRepository;

@Repository
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Order insertOrder(Order order) {
		Order savedOrder = orderRepository.save(order);
		return savedOrder;
	}
	
	@Override
	public Order selectOrder(Long orderId) {
		Order selectedOrder = orderRepository.findById(orderId).get();
		return selectedOrder;
	}
	
	//관리자 권한(오더 수정)
	@Override
	public Order updateOrder(Order updateOrder) throws Exception {
		Optional<Order> findOrderOptional =
				orderRepository.findById(updateOrder.getOrderId());
		Order updatedOrder=null;
		if(findOrderOptional.isPresent()) {
			Order order = findOrderOptional.get();
			//관리자가 수정할 수 있는 주문 정보(주문상태)
			order.setOrderPrice(updateOrder.getOrderPrice());
			order.setOrderStatus(updateOrder.getOrderStatus());
			updatedOrder=orderRepository.save(order);
		}else {
			throw new Exception("존재하지 않는 주문입니다.");
		}
		return updatedOrder;
	}

	@Override
	public void deleteOrder(Long orderId) throws Exception {
		Optional<Order> selectedOrderOptional = orderRepository.findById(orderId); 
		if(selectedOrderOptional.isEmpty()) {
			throw new Exception("존재하지않는주문입니다.");
		}else {
			orderRepository.delete(selectedOrderOptional.get());
		}
	}

	@Override
	public List<Order> selectList() {
		return orderRepository.findAll();
	}

	@Override
	public List<Order> getOrdersByUserId(String userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if	(userOptional.isPresent()) {
			User user = userOptional.get();
			return orderRepository.findOrdersByUser(user);
		} else {
			
			return new ArrayList<>(); // 사용자를 찾지 못한 경우 빈 목록을 반환
		}
	}

	@Override
	public List<Order> orderListByNewer(String userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if	(userOptional.isPresent()) {
			return orderRepository.orderListByNewer(userId);
		} else {
			
			return new ArrayList<>(); // 사용자를 찾지 못한 경우 빈 목록을 반환
		}
	}
	
	@Override
	public List<Order> orderListByOlder(String userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if	(userOptional.isPresent()) {
			return orderRepository.orderListByNewer(userId);
		} else {
			
			return new ArrayList<>(); // 사용자를 찾지 못한 경우 빈 목록을 반환
		}
	}



}
