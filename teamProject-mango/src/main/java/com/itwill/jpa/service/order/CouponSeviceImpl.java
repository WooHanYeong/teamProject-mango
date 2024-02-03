package com.itwill.jpa.service.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.order.CouponDao;
import com.itwill.jpa.dto.order.CouponDto;
import com.itwill.jpa.dto.order.OrderDto;
import com.itwill.jpa.entity.order.Coupon;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.repository.order.CouponRepository;

import jakarta.transaction.Transactional;

@Service
public class CouponSeviceImpl implements CouponService{

	@Autowired
	CouponRepository couponRepository;
	
	@Autowired
	CouponDao couponDao;
	
	//쿠폰 생성
	@Override
	public CouponDto saveCoupon(CouponDto dto) {
		Coupon coupon = couponRepository.save(Coupon.toEntity(dto));
		CouponDto couponDto = CouponDto.toDto(coupon);
		return couponDto;
	}
	
	//쿠폰 정보 수정
	@Transactional
	@Override
	public CouponDto updateCoupon(CouponDto dto) throws Exception{
		Coupon coupon = Coupon.builder()
							.couponId(dto.getCouponId())
							.couponName(dto.getCouponName())
							.couponType(dto.getCouponType())
							.couponCode(dto.getCouponCode())
							.couponDiscount(dto.getCouponDiscount())
							.couponExpirationDate(dto.getCouponExpirationDate())
							.couponIsUsed(dto.getCouponIsUsed())
							.build();
		Coupon updateCoupon = couponDao.updateCoupon(coupon);
		CouponDto couponDto = CouponDto.toDto(updateCoupon);
		return couponDto;
	}
	
	//쿠폰 한개 삭제하고 Dto에 삭제 쿠폰 정보 저장
	@Override
	public CouponDto deleteCoupon(Long couponId) throws Exception {
		Coupon coupon = couponRepository.findById(couponId).orElseThrow(() -> new IllegalArgumentException("쿠폰이 존재하지 않습니다."));
		couponRepository.deleteById(couponId);
		CouponDto couponDto = CouponDto.toDto(coupon);
		return couponDto;
	}
	
	//쿠폰 전체 삭제하고 Dto에 삭제 쿠폰 리스트 저장
	@Override
	public List<CouponDto> deleteAllCoupons() throws Exception {
		List<Coupon> couponList = couponRepository.findAll();
		List<CouponDto> couponDtoList = new ArrayList<CouponDto>();
		for (Coupon coupon : couponList) {
			couponDtoList.add(CouponDto.toDto(coupon));
		}
		couponRepository.deleteAll();
		return couponDtoList;
	}
		
	//유저의 쿠폰들 불러오기
	@Override
	public List<CouponDto> couponsByUserId(String userId) {
		List<Coupon> couponList = couponDao.getCouponsByUserId(userId);
		List<CouponDto> couponDtoList = new ArrayList<CouponDto>();
		for (Coupon coupon : couponList) {
			couponDtoList.add(CouponDto.toDto(coupon));
		}
		return couponDtoList;
	}
	
	//주문내역에서 해당 주문에 사용된 쿠폰 불러오기
	@Override
	public CouponDto findCouponByOrderId(Long orderId) {
		Coupon coupon = couponDao.getCouponByOrderId(orderId);
		CouponDto couponDto = CouponDto.toDto(coupon);
		return couponDto;
	}
	
	//쿠폰 할인 적용 시키기
	@Override
	public double applyCouponDiscount(Long couponId, double orderPrice) {
		Coupon coupon = couponRepository.findById(couponId).get();
		if (coupon != null) {
			double discountRate = coupon.getCouponDiscount();
			if (discountRate > 0) {
				// 할인율을 적용하여 할인액 계산
				double discountAmount = orderPrice * (discountRate / 100.0);
				double discountedTotal = orderPrice - discountAmount;
				return discountedTotal;
			}
		}
		// 할인 적용되지 않는 경우 원래 총액 반환
		return orderPrice;
	}
	
}
		
	
