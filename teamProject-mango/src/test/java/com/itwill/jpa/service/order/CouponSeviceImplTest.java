package com.itwill.jpa.service.order;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.dao.order.OrderDao;
import com.itwill.jpa.dao.user.UserDao;
import com.itwill.jpa.dto.order.CouponDto;
import com.itwill.jpa.entity.order.Coupon;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.order.CouponRepository;
import com.itwill.jpa.repository.order.OrderRepository;
import com.itwill.jpa.repository.user.UserRepository;
import com.itwill.jpa.service.user.UserServiceImpl;

import jakarta.transaction.Transactional;

class CouponSeviceImplTest extends TeamProjectMangoApplicationTest{
	
	@Autowired
	CouponSeviceImpl couponSeviceImpl;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	CouponRepository couponRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	UserDao userDao;
	
	
	//쿠폰 생성(성공)
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void couponCreateTest() {
		Coupon coupon = new Coupon();
		User user = userDao.findUser("why3795");
		Order order = orderDao.selectOrder(9L);
		
		coupon.setUser(user);
		coupon.setOrder(order);
		
		CouponDto couponDto = CouponDto.toDto(coupon);
		
		couponDto.setCouponCode("00000033");
		couponDto.setCouponId(null);
		couponDto.setCouponDiscount(50.0);
		couponDto.setCouponExpirationDate(null);
		couponDto.setCouponIsUsed(0);
		couponDto.setCouponName("테스트쿠폰");
		couponDto.setCouponType("100년쿠폰");
		
		CouponDto createdCouponDto = couponSeviceImpl.saveCoupon(couponDto);
		
		System.out.println(createdCouponDto);
		
		
	}
	
	//쿠폰 정보 수정(성공)
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void couponUpdateTest() throws Exception {

		Coupon coupon = couponRepository.findById(1L).get();
		CouponDto couponDto = CouponDto.toDto(coupon);
		couponDto.setCouponCode("33333333");
		couponDto.setCouponDiscount(30.0);
		couponDto.setCouponExpirationDate(null);
		couponDto.setCouponIsUsed(1);
		couponDto.setCouponName("날이면 날마다 오는 쿠폰");
		couponDto.setCouponType("12개월쿠폰");
		CouponDto updatedCouponDto = couponSeviceImpl.updateCoupon(couponDto);
		System.out.println(updatedCouponDto);
	
	}

	//쿠폰 한개 삭제(성공)
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void couponDeleteTest() throws Exception {
		
		couponSeviceImpl.deleteCoupon(1L);

	}

	//쿠폰 전체 삭제(성공)
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void couponDeleteAllTest() throws Exception {
		
		couponSeviceImpl.deleteAllCoupons();

	}
	
	//유저 아이디로 쿠폰 전체 불러오기(성공)
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void couponByUserIdTest(){
		
		List<CouponDto> couponDtoList = couponSeviceImpl.couponsByUserId("cgj22");
		System.out.println(couponDtoList);

	}

	//주문내역에서 해당 주문에 사용된 쿠폰 불러오기(성공)
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findCouponByOrderIdTest(){
		
		CouponDto couponDto = couponSeviceImpl.findCouponByOrderId(35L);
		System.out.println(couponDto);
	}
}