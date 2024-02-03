package com.itwill.jpa.repository.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.order.Coupon;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.user.User;
@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long>{
	
	List<Coupon> findCouponsByUser(User user);
	
	Coupon findCouponByOrder(Order order);
}
