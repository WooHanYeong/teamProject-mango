package com.itwill.jpa.repository.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.user.UserRepository;

class DeliveryRepositoryTest {

	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Autowired
	UserRepository userRepository;
	

	
	@Test
	//@Disabled
	void test() {
		Delivery delivery = Delivery.builder()
				.deliveryAddress("서울")
				.deliveryCompany("롯데택배")
				.deliveryName("예린")
				.deliveryId(null)
				.deliveryPhone("12121")
				.build();
		
		User user = User.builder()
				.userAddress("서울")
				.userEmail("ㅇㅇㅇ")
				.userGender("여")
				.userId("dff")
				.userJumin("123")
				.userName("아아아")
				.userPhone("123456789")
				.userPw("dff")
				.build();
		
		delivery.setUser(user);
		
//		deliveryRepository.save(delivery);
//		userRepository.save(user);
	}

}
