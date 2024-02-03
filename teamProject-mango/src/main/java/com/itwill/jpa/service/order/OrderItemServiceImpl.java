package com.itwill.jpa.service.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.order.OrderItemDao;
import com.itwill.jpa.dto.order.OrderDto;
import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.exception.order.OrderItemNotFoundException;
import com.itwill.jpa.repository.order.OrderItemRepository;
import com.itwill.jpa.repository.order.OrderRepository;
import com.itwill.jpa.repository.user.UserRepository;
@Service
public class OrderItemServiceImpl implements OrderItemService{

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	OrderItemDao orderItemDao;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	UserRepository userRepository;

	//아이템 추가
	@Override
	public OrderItemDto saveOrderItem(OrderItemDto orderItem) {
		OrderItem order = orderItemRepository.save(OrderItem.toEntity(orderItem));
		OrderItemDto orderItemDto = OrderItemDto.toDto(order);
		return orderItemDto;
	
	}

	//아이템 업데이트
		@Override
		public OrderItemDto updateOrderItem(OrderItemDto dto) {
		  OrderItem orderItem = orderItemDao.updateOrderItem(OrderItem.toEntity(dto));
		  OrderItemDto orderItemDto = OrderItemDto.toDto(orderItem);
		    return orderItemDto;
		}
	
	//아이템아이디 받아와서 삭제
	@Override
	public OrderItemDto deleteOrderItem(Long oiId) throws Exception {
		OrderItem orderItem = orderItemRepository.findById(oiId)
				.orElseThrow(() -> new IllegalArgumentException("주문아이템이 존재하지 않습니다."));
		orderItemRepository.deleteById(oiId);
		OrderItemDto orderItemDto = OrderItemDto.toDto(orderItem);
		return orderItemDto;
	}

	// 유저 아이디 아이템 모두 삭제하고 Dto에 삭제 주문 정보 저장
	@Override
	public List<OrderItemDto> deleteAllOrderItem() throws Exception {
		List<OrderItem> orderItemList = orderItemRepository.findAll();
		List<OrderItemDto> orderItemDtoList = new ArrayList<OrderItemDto>();
		for (OrderItem orderItem : orderItemList) {
			orderItemDtoList.add(OrderItemDto.toDto(orderItem));
		}
		orderRepository.deleteAll();
		return orderItemDtoList;

	}

	//아이템 아이디로 아이템 선택하기
	@Override
	public OrderItemDto findOrderItem(Long id) {
		OrderItem selectedOrderItem = orderItemRepository.findById(id).get();
		OrderItemDto orderItemDto  = OrderItemDto.toDto(selectedOrderItem);
		return orderItemDto;
	}

	//오더 아이디를 받아와서 아이템리스트 나열
	@Override
	public List<OrderItemDto> orderItemsByOrderId(Long orderId) {
		Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
        	Order order = orderOptional.get();
        	List<OrderItem> orderItems = orderItemRepository.findByOrder(order);
        	List<OrderItemDto> orderItemDtos = new ArrayList<>();

        	for (OrderItem orderItem : orderItems) {
        	    OrderItemDto orderItemDto = OrderItemDto.toDto(orderItem);
        	    orderItemDtos.add(orderItemDto);
        	}
        	return orderItemDtos;
        } else {
            return new ArrayList<>(); // 오더 아이디를 찾지 못한 경우 빈 목록을 반환
        }
	}

	@Override
	public List<OrderItemDto> orderItemsByUserId(String userId) {
		  Optional<User> userOptional = userRepository.findById(userId);

	        if (userOptional.isPresent()) {
	            User user = userOptional.get();
	            List<OrderItemDto> userOrderedItems = new ArrayList<>();
	            

	            // 사용자 엔티티에서 주문 목록을 가져옴
	            List<Order> orders = user.getOrders();

	            // 각 주문에 속한 주문 항목 및 연결된 제품을 가져옴
	            for (Order order : orders) {
	                List<OrderItem> orderItems = order.getOrderItems();
	                for (OrderItem orderItem : orderItems) {
	                    userOrderedItems.add(OrderItemDto.toDto(orderItem));
	                }
	            }

	            return userOrderedItems;
	        } else {
	            return Collections.emptyList(); // 사용자를 찾을 수 없는 경우 빈 리스트 반환
	        }
	    }

	}

	

	
