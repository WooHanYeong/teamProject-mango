package com.itwill.jpa.service.order;

import java.util.List;

import com.itwill.jpa.dto.order.DeliveryDto;

public interface DeliveryService {
	
	DeliveryDto saveDelivery(DeliveryDto delivery);
	
	DeliveryDto updateDelivery(DeliveryDto delivery) throws Exception;
	
	DeliveryDto deleteDelivery(Long deliveryId) throws Exception;
	
	List<DeliveryDto> deliverys();
	
	List<DeliveryDto> findDelivery(String userId);
	
	DeliveryDto findByDeliveryId(Long deliveryId);
	
	
	
}