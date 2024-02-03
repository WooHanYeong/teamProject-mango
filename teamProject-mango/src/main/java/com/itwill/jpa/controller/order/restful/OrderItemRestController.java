
package com.itwill.jpa.controller.order.restful;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.dto.order.OrderDto;
import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.service.order.OrderItemService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orderItem")
@RequiredArgsConstructor//생성자를 자동으로 생성하여 멤버필드(DI)주입 해주는 어노테이션
public class OrderItemRestController {

	
	private final OrderItemService orderItemService;
	
	/* Restful OrderItem */
	
	@Operation(summary="주문내역한개 삭제")
	@DeleteMapping("/delete/{oiId}")
	public ResponseEntity<?> deleteOrderItem(@PathVariable(value = "oiId") Long oiId ){
		try {
			orderItemService.deleteOrderItem(oiId);
			return ResponseEntity.status(HttpStatus.OK).body("주문번호"+oiId +"번이 삭제되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	@Operation(summary="오더아이디로 주문아이템 불러오기")
	@GetMapping("order/{orderId}")
	public ResponseEntity<?> getOrderItemsByOrderId(@PathVariable(value = "orderId") Long orderId){
		try {
			List<OrderItemDto> orderItemsOrderId = orderItemService.orderItemsByOrderId(orderId);
			
			return ResponseEntity.status(HttpStatus.OK).body(orderItemsOrderId);
		}catch(Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	@Operation(summary="유저아이디로 주문아이템 불러오기")
	@GetMapping("user/{userId}")
	public ResponseEntity<?> getOrderItemsByUserId(@PathVariable(value = "userId") String userId){
		try {
			List<OrderItemDto> orderItemsUserId = orderItemService.orderItemsByUserId(userId);
			
			return ResponseEntity.status(HttpStatus.OK).body(orderItemsUserId);
		}catch(Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	


}
