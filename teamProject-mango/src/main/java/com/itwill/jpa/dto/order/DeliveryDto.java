package com.itwill.jpa.dto.order;


import com.itwill.jpa.entity.order.Delivery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
//웹에서 고객에게 보여주기 위한 정보를 담은 객체(Dto)
public class DeliveryDto {
	
	private Long deliveryId;

	private String deliveryName;
	
	private String deliveryPhone;
	
	private String deliveryAddress;
	
	private String deliveryCompany; //담당 택배 회사(ex. 우체국, CJ대한통운)
	
	private String userId;
//	//복원
//	private User user;
	
	//Dto에서 고객에게 보여주는 주문 정보들이 어떤값인지를 설정하는 생성자(초기화)
	public  DeliveryDto(Delivery delivery) {
		this.deliveryName = delivery.getDeliveryName();
		this.deliveryPhone = delivery.getDeliveryPhone();
		this.deliveryAddress = delivery.getDeliveryAddress();
		this.deliveryCompany = delivery.getDeliveryCompany();
		this.userId = delivery.getUser().getUserId();
	}
	
	//Dto -> entity 변환해주는 매서드
	public static DeliveryDto toDto(Delivery entity) {
		return DeliveryDto.builder()
					   .deliveryId(entity.getDeliveryId())
					   .deliveryName(entity.getDeliveryName())
					   .deliveryPhone(entity.getDeliveryPhone())
					   .deliveryAddress(entity.getDeliveryAddress())
					   .deliveryCompany(entity.getDeliveryCompany())
					   .userId(entity.getUser().getUserId())
					   .build();
	}

}
