package com.itwill.jpa.service.order;

import java.util.List;

import com.itwill.jpa.dto.order.CouponDto;

public interface CouponService {
	
	//쿠폰생성
	CouponDto saveCoupon(CouponDto couponDto);
	//쿠폰수정(관리자)
	CouponDto updateCoupon(CouponDto couponDto) throws Exception;
	//쿠폰 삭제
	CouponDto deleteCoupon(Long couponId) throws Exception;
	//쿠폰 전체 삭제
	List<CouponDto> deleteAllCoupons() throws Exception;
	//유저의 쿠폰들 불러오기
	List<CouponDto> couponsByUserId(String userId);
	//주문내역에서 해당 주문에 사용된 쿠폰 불러오기
	CouponDto findCouponByOrderId(Long orderId);
	//쿠폰 할인 적용 시키기
	public double applyCouponDiscount(Long couponId, double orderPrice);
}
