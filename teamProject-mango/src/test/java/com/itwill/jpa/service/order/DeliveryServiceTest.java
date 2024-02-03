package com.itwill.jpa.service.order;



import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.dao.order.DeliveryDao;
import com.itwill.jpa.dto.order.DeliveryDto;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.order.DeliveryRepository;
import com.itwill.jpa.repository.user.UserRepository;

import jakarta.transaction.Transactional;


@SpringBootTest
@Transactional
class DeliveryServiceTest {

	@Autowired
	DeliveryService deliveryService;
	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Autowired
	DeliveryDao deliveryDao;
	@Autowired
	UserRepository userRepository;
	
	//배송 생성 성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void insert() {
		DeliveryDto deliveryDto = new DeliveryDto();
		deliveryDto.setDeliveryAddress("서울시");
		deliveryDto.setDeliveryCompany("롯데");
		deliveryDto.setDeliveryId(null);
		deliveryDto.setDeliveryName("집");
		deliveryDto.setDeliveryPhone("1234");
		
		User user1 = User.builder()
                .userId("kbs")
                .userPw("1111")
                .userName("고범석")
                .userAddress("서울시 강남")
                .userEmail("kbs@naver.com")
                .userJumin("970000-0000000")
                .userPhone("010-1234-5678")
                .userGender("남")
                .build();

//		delivery.setUser(user1);
		DeliveryDto savedDeliveryDto = deliveryService.saveDelivery(deliveryDto);
		System.out.println(savedDeliveryDto);
		
		
	}
	//배송 수정 성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void update() throws Exception {
		DeliveryDto deliveryDto = deliveryService.findByDeliveryId(3L);
		deliveryDto.setDeliveryAddress("부산광역시");
		
		DeliveryDto updateDeliveryDto = deliveryService.updateDelivery(deliveryDto);
		System.out.println(updateDeliveryDto);
		
	}
	//배송 삭제 성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void delete() throws Exception{
		deliveryService.deleteDelivery(3L);
		
	}
	
	//배송지 전체 찾기 성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deliverys(){
		List<DeliveryDto> findDelivery = deliveryService.deliverys();
		System.out.println(findDelivery);
	}
	
	//배송번호로 배송지 찾기 성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByDeliveryId(){
		DeliveryDto findDelivery = deliveryService.findByDeliveryId(10L);
		System.out.println(findDelivery);
	}
	
	//유저 아이디로 배송지 찾기 성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByDeliveryByUserId() {
		List<DeliveryDto> findDelivery = deliveryService.findDelivery("wsm55");
		System.out.println(findDelivery);
	}
	
}