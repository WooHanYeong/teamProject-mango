package com.itwill.jpa.repository.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.order.Coupon;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.user.UserRepository;

class CouponRepositoryTest extends TeamProjectMangoApplicationTest{

	@Autowired
	CouponRepository couponRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void test() {
		Coupon coupon = Coupon.builder()
							  .couponCode("231231231")
							  .couponDiscount(30.0)
							  .couponExpirationDate(null)
							  .couponIsUsed(0)
							  .couponType("1개월쿠폰")
							  .createdAt(null)
							  .updatedAt(null)
							  .build();
		
		User user = User.builder()
						.userId("111")
						.userPw("111")
						.userName("박명수")
						.userAddress("군산")
						.userEmail("naver")
						.userPhone("01023023234")
						.build();
						
					
		coupon.setUser(user);
		couponRepository.save(coupon);
		userRepository.save(user);
				
	}

}
