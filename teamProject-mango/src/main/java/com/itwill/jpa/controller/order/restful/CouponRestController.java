
package com.itwill.jpa.controller.order.restful;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.dto.order.CouponDto;
import com.itwill.jpa.service.order.CouponService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/coupon")
@RequiredArgsConstructor//생성자를 자동으로 생성하여 멤버필드(DI)주입 해주는 어노테이션
public class CouponRestController {

	private final CouponService couponService;

	/* Restful Coupon */
	
	// 쿠폰생성
	@Operation(summary = "쿠폰생성[성공]")
	@PostMapping("/create")
	public ResponseEntity<?> createCoupon(@RequestBody CouponDto couponDto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(couponService.saveCoupon(couponDto));
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
		
	}
	
}
		
