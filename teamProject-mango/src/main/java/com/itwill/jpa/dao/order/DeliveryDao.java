package com.itwill.jpa.dao.order;

import java.util.List;

import com.itwill.jpa.entity.order.Delivery;

public interface DeliveryDao {
	
	Delivery insertDelivery(Delivery delivery);
	
	Delivery updateDelivery(Delivery updateDelivery) throws Exception;
	
	void deleteDelivery(Long DeliveryId) throws Exception;
	
	void selectList();
	
	List<Delivery> getDeliveriesByUserId(String userId);
	
	Delivery findByDeliveryId(Long DeliveryId);
}
