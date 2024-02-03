package com.itwill.jpa.dao.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.order.Coupon;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.order.CouponRepository;
import com.itwill.jpa.repository.order.OrderRepository;
import com.itwill.jpa.repository.user.UserRepository;

@Repository
public class CouponDaoImpl implements CouponDao{

	@Autowired
	CouponRepository couponRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public Coupon insertCoupon(Coupon coupon) {
		Coupon savedCoupon = couponRepository.save(coupon);
		return savedCoupon;
	}

	@Override
	public Coupon selectCoupon(Long couponId) {
		Coupon selectedCoupon = couponRepository.findById(couponId).get();
		return selectedCoupon;
	}

	//관리자 권한(쿠폰 수정)
	@Override
	public Coupon updateCoupon(Coupon updateCoupon) throws Exception {
		Optional<Coupon> findCouponOptional =
				couponRepository.findById(updateCoupon.getCouponId());
		Coupon updatedCoupon=null;
		if(findCouponOptional.isPresent()) {
			Coupon coupon = findCouponOptional.get();
			//관리자가 수정할 수 있는 주문 정보(주문상태)
			coupon.setCouponName(updateCoupon.getCouponName());
			coupon.setCouponType(updateCoupon.getCouponType());
			coupon.setCouponCode(updateCoupon.getCouponCode());
			coupon.setCouponDiscount(updateCoupon.getCouponDiscount());
			coupon.setCouponExpirationDate(updateCoupon.getCouponExpirationDate());
			coupon.setCouponIsUsed(updateCoupon.getCouponIsUsed());
			updatedCoupon=couponRepository.save(coupon);
		}else {
			throw new Exception("존재하지 않는 쿠폰입니다.");
		}
		return updatedCoupon;
	}

	@Override
	public void deleteCoupon(Long couponId) throws Exception {
		Optional<Coupon> selectedCouponOptional = couponRepository.findById(couponId); 
		if(selectedCouponOptional.isEmpty()) {
			throw new Exception("존재하지 않는 쿠폰입니다.");
		}
		couponRepository.delete(selectedCouponOptional.get());
		
	}

	@Override
	public List<Coupon> getCouponsByUserId(String userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if	(userOptional.isPresent()) {
			User user = userOptional.get();
			return couponRepository.findCouponsByUser(user);
		} else {
			
			return new ArrayList<>(); // 사용자를 찾지 못한 경우 빈 목록을 반환
		}
	}

	@Override
	public List<Coupon> selectList() {
		return couponRepository.findAll();
	}

	@Override
	public Coupon getCouponByOrderId(Long orderId) {
		Optional<Order> orderOptional = orderRepository.findById(orderId);
		if	(orderOptional.isPresent()) {
			Order order = orderOptional.get();
			return couponRepository.findCouponByOrder(order);
		} else {
			
			return null;
		}
	}

}
