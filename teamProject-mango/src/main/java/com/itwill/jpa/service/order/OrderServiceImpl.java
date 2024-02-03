package com.itwill.jpa.service.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.order.OrderDao;
import com.itwill.jpa.dao.user.UserDao;
import com.itwill.jpa.dto.order.OrderDto;
import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.order.OrderRepository;
import com.itwill.jpa.repository.user.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDao userDao;

	//주문 생성
	@Override
	public OrderDto saveOrder(OrderDto dto) {
		
		Order order = orderRepository.save(Order.toEntity(dto));
		OrderDto orderDto = OrderDto.toDto(order);
		return orderDto;
	}
	
	//주문 정보 수정
	@Transactional
	@Override
	public OrderDto updateOrder(OrderDto dto) throws Exception{
		Order order = orderDao.updateOrder(Order.toEntity(dto));
		OrderDto orderDto = OrderDto.toDto(order);
		return orderDto;
	}

	//주문 한개 삭제하고 Dto에 삭제 주문 정보 저장
	@Override
	public OrderDto deleteOrder(Long orderId) throws Exception {
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("주문이 존재하지 않습니다."));
		orderRepository.deleteById(orderId);
		OrderDto orderDto = OrderDto.toDto(order);
		return orderDto;
	}
		
	
	//주문 전체 삭제하고 Dto에 삭제 주문 리스트 저장
	@Override
	public List<OrderDto> deleteAllOrder() throws Exception {
		List<Order> orderList = orderRepository.findAll();
		List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
		for (Order order : orderList) {
			orderDtoList.add(OrderDto.toDto(order));
		}
		orderRepository.deleteAll();
		return orderDtoList;
	}

	//유저 아이디로 주문 전체 불러오기
	@Override
	public List<OrderDto> ordersByUserId(String UserId) {
		List<Order> orderList = orderDao.getOrdersByUserId(UserId);
		List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
		for (Order order : orderList) {
			orderDtoList.add(OrderDto.toDto(order));
		}
		return orderDtoList;
	}
	
	//전체 주문 불러오기(관리자)
	@Override
	public List<OrderDto> orders() {
		List<Order> orderList = orderRepository.findAll();
		List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
		for (Order order : orderList) {
			orderDtoList.add(OrderDto.toDto(order));
		}
		return orderDtoList;
	}

	@Override
	public List<OrderDto> orderListByNewer(String userId) {
		List<Order> orderList = orderDao.orderListByNewer(userId);
		List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
		for (Order order : orderList) {
			orderDtoList.add(OrderDto.toDto(order));
		}
		return orderDtoList;
	}

	@Override
	public List<OrderDto> orderListByOlder(String userId) {
		List<Order> orderList = orderRepository.orderListByOlder(userId);
		List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
		for (Order order : orderList) {
			orderDtoList.add(OrderDto.toDto(order));
		}
		return orderDtoList;
	}
	
	//주문 총금액 계산 메서드
	@Override
	public double calculateTotalOrderPrice(String userId) {
		
		double orderPrice=0;
		
		 // 유저아이디로 주문 목록을 가져오는 메서드
	    List<Order> userOrders = orderDao.getOrdersByUserId(userId);
	    
	    // 사용자의 주문 목록을 반복하면서 총 주문 금액 계산
	    for (Order order : userOrders) {
	        List<OrderItem> orderItemList = order.getOrderItems();
	       
			// 주문 항목 목록을 DTO로 변환하고 가격과 수량을 곱하여 총 주문 금액 계산
			for (OrderItem orderItem : orderItemList) {
				OrderItemDto dto = OrderItemDto.toDto(orderItem);
				double itemPrice = dto.getProductPrice();
				int itemQty = dto.getOiQty();
				orderPrice += itemPrice * itemQty;
			}
	        
	    }
		return orderPrice;
	}
	
	//멤버쉽 구매 결과 받아서 확인하고 유저 DB에 MemberShip true로 저장
	@Override
	public boolean isMembershipPurchasedAndSaveMembership(String userId) {
		// 사용자 정보를 데이터베이스에서 가져옴
		User user = userDao.findUser(userId);
		
		if (user == null) {
			// 사용자가 없으면 구매 실패
			return false;
		}
		
		if (user.isMembership() == true) {
			// 이미 멤버십을 구매한 경우 구매 실패
			return false;
		}
		
		// 멤버십 결제 로직 (예: 결제가 성공하면 멤버십을 구매한 것으로 간주)
		boolean membershipPurchaseSuccess = performMembershipPurchaseLogic(userId);
		
		if (membershipPurchaseSuccess) {
			// 멤버십 구매가 성공하면 사용자 멤버십 정보 true로 업데이트
			user.setMembership(true);
			userRepository.save(user); // 멤버십 정보를 사용자 데이터베이스에 저장
			return true;
		}
		
		return false; // 결제 실패
	}
	
	//멤버십 구매 결과 메서드
	@Override
	public boolean performMembershipPurchaseLogic(String userId) {
		// 여기에 실제 멤버십 결제 로직을 구현
		// 외부 결제 게이트웨이와 연동하여 결제 처리
		// 결제가 성공하면 true 반환, 실패하면 false 반환
		return true; // 일단 임시로 멤버십 구매 성공으로 가정
	}
	
	
	

	
	


 



}
