package com.itwill.jpa.dao.order;

import java.util.List;

import com.itwill.jpa.entity.order.Coupon;

public interface CouponDao {

	Coupon insertCoupon(Coupon coupon);
	
	Coupon selectCoupon(Long couponId);
	
	// 관리자(admin)가 쿠폰 수정 가능
	Coupon updateCoupon(Coupon coupon) throws Exception;
	
	void deleteCoupon(Long couponId) throws Exception;
	
	List<Coupon> getCouponsByUserId(String userId);
	
	List<Coupon> selectList();
	
	Coupon getCouponByOrderId(Long orderId);
			
}
