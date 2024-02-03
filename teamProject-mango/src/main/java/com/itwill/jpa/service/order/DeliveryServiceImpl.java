package com.itwill.jpa.service.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.order.DeliveryDao;
import com.itwill.jpa.dto.order.DeliveryDto;
import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.repository.order.DeliveryRepository;
import com.itwill.jpa.repository.user.UserRepository;

import jakarta.transaction.Transactional;
@Service
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Autowired
	DeliveryDao deliveryDao;
	
	@Autowired
	UserRepository userRepository;
	
	//배송지 정보 저장
	@Override
	public DeliveryDto saveDelivery(DeliveryDto dto) {
		
		Delivery delivery = deliveryRepository.save(Delivery.toEntity(dto));
		DeliveryDto deliveryDto = DeliveryDto.toDto(delivery);
		
		return deliveryDto;
	}
	
	//배송지 정보 수정
	@Transactional
	@Override
	public DeliveryDto updateDelivery(DeliveryDto dto) throws Exception{
		Delivery updateDelivery = deliveryDao.updateDelivery(Delivery.toEntity(dto));
		DeliveryDto updateDeliveryDto = DeliveryDto.toDto(updateDelivery);
		return updateDeliveryDto;
	}

	//배송지 정보 삭제 Dto에 삭제 배송지 정보 저장
	@Override
	public DeliveryDto deleteDelivery(Long deliveryId) throws Exception {
		Delivery delivery = deliveryRepository.findById(deliveryId).orElseThrow(() -> new IllegalArgumentException("배송지가 존재하지 않습니다."));
		deliveryRepository.deleteById(deliveryId);
		DeliveryDto deliveryDto = DeliveryDto.toDto(delivery);
		return deliveryDto;
		
	}

	//배송지 정보들 불러오기
	@Override
	public List<DeliveryDto> deliverys() {
		List<Delivery> deliveryList = deliveryRepository.findAll();
		List<DeliveryDto> deliveryDtoList = new ArrayList<DeliveryDto>();
		for (Delivery delivery : deliveryList) {
			deliveryDtoList.add(DeliveryDto.toDto(delivery));
		}
		return deliveryDtoList;
	
	}

	
	//유저 아이디로 배송지 정보 불러오기
	@Override
	public List<DeliveryDto> findDelivery(String userId) {
		List<Delivery> deliveryList = deliveryDao.getDeliveriesByUserId(userId);
		List<DeliveryDto> deliveryDtoList = new ArrayList<DeliveryDto>();
		for (Delivery delivery : deliveryList) {
			deliveryDtoList.add(DeliveryDto.toDto(delivery));
		}
		return deliveryDtoList;
	}


	//배송지아이디로 배송지 정보 찾기
	@Override
	public DeliveryDto findByDeliveryId(Long deliveryId) {
		Delivery delivery = deliveryRepository.findById(deliveryId).get();
		DeliveryDto deliveryDto = DeliveryDto.toDto(delivery);
		return deliveryDto;
	}

}