package com.itwill.jpa.entity.order;


import com.itwill.jpa.dto.order.DeliveryDto;
import com.itwill.jpa.entity.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "delivery")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Delivery {
	@Id
	@SequenceGenerator(name = "DELIVERY_NO_SEQ",sequenceName = "DELIVERY_NO_SEQ",initialValue = 1 , allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DELIVERY_NO_SEQ")
	private Long deliveryId;
	
	private String deliveryName;
	
	private String deliveryPhone;
	
	private String deliveryAddress;
	
	private String deliveryCompany;
	
	// delivery와 user n대1
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	@ToString.Exclude
	private User user;

	
	//Dto -> entity 변환해주는 매서드
	public static Delivery toEntity(DeliveryDto dto) {
		return Delivery.builder()
					   .deliveryId(dto.getDeliveryId())
					   .deliveryName(dto.getDeliveryName())
					   .deliveryPhone(dto.getDeliveryPhone())
					   .deliveryAddress(dto.getDeliveryAddress())
					   .deliveryCompany(dto.getDeliveryCompany())
					   .user(User.builder().userId(dto.getUserId()).build()) // userId 설정
					   .build();
	}
	
}
