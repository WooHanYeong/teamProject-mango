
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.dto.order.OrderDto;
import com.itwill.jpa.service.order.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor//생성자를 자동으로 생성하여 멤버필드(DI)주입 해주는 어노테이션
public class OrderRestController {

	private final OrderService orderService;
	
	/* Restful Order */

	// 주문생성
	@Operation(summary = "주문생성[성공]")
	@PostMapping("/create")
	public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrder(orderDto));
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
			
			
		}
	}
	
	// 주문수정(관리자권한 orderPrice, orderStatus 수정가능)
	@Operation(summary = "주문수정[성공]")
	@PutMapping("/update")
	public ResponseEntity<?> updateOrder(@RequestBody OrderDto orderDto) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrder(orderDto));
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	// 주문 1개 삭제
	@Operation(summary = "주문한개삭제[성공]")
	@DeleteMapping("/delete/{orderId}")
	public ResponseEntity<?> deleteOrder(@PathVariable(value = "orderId") Long orderId) {
		try {
			orderService.deleteOrder(orderId);
			return ResponseEntity.status(HttpStatus.OK).body("주문번호" + orderId + "번이 삭제 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	// 주문 전체 삭제
	@Operation(summary = "주문전체삭제[성공]")
	@DeleteMapping("/delete/all")
	public ResponseEntity<?> deleteAllOrder() {
		try {
			orderService.deleteAllOrder();
			return ResponseEntity.status(HttpStatus.OK).body("전체 주문이 삭제 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	// 유저가 만든 주문 전체 불러오기
	@Operation(summary = "로그인한 유저 주문내역 불러오기[성공]")
	@GetMapping("/{userId}")
	public ResponseEntity<?> getOrdersByUserId(@PathVariable(value = "userId") String userId) {
		try {
			List<OrderDto> userOrders = orderService.ordersByUserId(userId);
			return ResponseEntity.status(HttpStatus.OK).body(userOrders);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
		
	}
	
	// 전체 유저의 주문 전체 불러오기(관리자권한)
	@Operation(summary = "사이트 전체 주문 내역 불러오기(관리자)[성공]")
	@GetMapping("/all") 
	public ResponseEntity<?> getAllOrders() {
		try {
			List<OrderDto> orders = orderService.orders();
			return ResponseEntity.status(HttpStatus.OK).body(orders);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	//주문 최신순으로 나열하기
	@Operation(summary = "주문 최신순으로 나열하기[성공]")
	@GetMapping("/SortByLatestOrder/{userId}")
	public ResponseEntity<?> getNewerOrdersByUserId(@PathVariable(value = "userId") String userId) {
		try {
			List<OrderDto> orders = orderService.orderListByNewer(userId);
			
			if (orders.isEmpty()) {
				// 주문 내역이 없을 경우 404 Not Found를 반환
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("주문 내역이 없습니다.");
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(orders);
			
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	//주문 오래된순으로 나열하기
	@Operation(summary = "주문 오래된순으로 나열하기[성공]")
	@GetMapping("/SortByOldestOrder/{userId}")
	public ResponseEntity<?> getOlderOrdersByUserId(@PathVariable(value = "userId") String userId) {
		try {
			List<OrderDto> orders = orderService.orderListByOlder(userId);
			
			if (orders.isEmpty()) {
				// 주문 내역이 없을 경우 404 Not Found를 반환
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("주문 내역이 없습니다.");
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(orders);
			
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	
}
	
