package com.itwill.jpa.service.order;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.dao.order.OrderDao;
import com.itwill.jpa.dao.order.OrderItemDao;
import com.itwill.jpa.dao.product.ProductDao;
import com.itwill.jpa.dto.order.OrderDto;
import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.Order.OrderStatus;
import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.order.OrderItemRepository;
import com.itwill.jpa.repository.order.OrderRepository;

import jakarta.transaction.Transactional;
import lombok.ToString;
@SpringBootTest
@Transactional
class OrderItemServiceTest {

	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	OrderItemDao orderItemDao;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ProductDao productDao;
	
	//성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void insert() {
		OrderItem orderItem = new OrderItem();
//		Order order = orderDao.selectOrder(947L);
		Product product = productDao.selectProduct(38L);
		orderItem.setOiId(null);
		orderItem.setOiQty(3);
		orderItem.setProduct(product);
		
		
		OrderItemDto orderItemDto = OrderItemDto.toDto(orderItem);
		
		OrderItemDto savedOrderItem = orderItemService.saveOrderItem(orderItemDto);
		
		System.out.println(savedOrderItem);
		

	}
	
	//성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void update(){
		
		OrderItem orderItem = orderItemDao.selectOrderItem(1202L);
		Product product = productDao.selectProduct(43L);
		orderItem.setOiQty(8);
		orderItem.setProduct(product);
		
		OrderItemDto orderItemDto = OrderItemDto.toDto(orderItem);
		
		OrderItemDto updateOrderItem = orderItemService.updateOrderItem(orderItemDto);
		
		System.out.println(updateOrderItem);
		
		
	}
	
	//성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void delete() throws Exception{
		orderItemService.deleteOrderItem(1202L);
	}
	
	//성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deleteAll() throws Exception{
		orderItemService.deleteAllOrderItem();
	}
	
	//성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findOrderItem() {
		OrderItemDto orderItemDto = orderItemService.findOrderItem(1154L);
		System.out.println(orderItemDto);
	}
	
	//성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void orderItemsByOrderId() {
		List<OrderItemDto> orderItems = orderItemService.orderItemsByOrderId(915L);
		System.out.println("오더아이템들-->"+orderItems);
	}
	
	//성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void orderItemsByUserId() {
		List<OrderItemDto> orderItems = orderItemService.orderItemsByUserId("why3795");
		System.out.println(orderItems);
	}
	
}
