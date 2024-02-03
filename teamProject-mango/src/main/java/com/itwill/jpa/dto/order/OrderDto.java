package com.itwill.jpa.dto.order;

import java.util.ArrayList;
import java.util.List;

import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.Order.OrderStatus;
import com.itwill.jpa.entity.order.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

//웹에서 고객에게 목적에 따라 데이터를 선택적으로 보여주기 위해서 엔티티 속에서 골라낸 정보를 담은 객체(Dto)
public class OrderDto {

	private Long orderId;
	
	private int orderPrice;
	
	private OrderStatus orderStatus; //주문 상태

	private String userId;
	
	private Long deliveryId;
	@Builder.Default
	private List<OrderItemDto> orderItemDtos = new ArrayList<>();
	
	
	//Dto에서 고객에게 보여주는 주문 정보들이 어떤값인지를 설정하는 생성자(초기화)
	public OrderDto(Order order) {
		
		this.orderId = order.getOrderId();
		this.orderPrice = order.getOrderPrice();
		this.orderStatus = order.getOrderStatus();
		this.userId = order.getUser().getUserId();
		this.deliveryId = order.getDelivery().getDeliveryId();
		
	}
	
	//Entity to Dto 변환
	public static OrderDto toDto(Order entity) {
		OrderDto orderDto = OrderDto.builder()
									.orderId(entity.getOrderId())
									.orderPrice(entity.getOrderPrice())
									.orderStatus(entity.getOrderStatus())
									.userId(entity.getUser().getUserId())
									.deliveryId(entity.getDelivery().getDeliveryId())
									.build();
		
		// OrderItem 엔티티 목록을 OrderItemDto 목록으로 변환하여 설정
		List<OrderItemDto> orderItemDtoList = new ArrayList<>();
		for (OrderItem orderItem : entity.getOrderItems()) {
			orderItemDtoList.add(OrderItemDto.toDto(orderItem));
		}
		orderDto.setOrderItemDtos(orderItemDtoList);

		return orderDto;
	}
	
}
	
		

	
	

					
			

			
