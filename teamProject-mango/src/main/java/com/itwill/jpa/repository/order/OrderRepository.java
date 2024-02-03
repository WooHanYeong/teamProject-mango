package com.itwill.jpa.repository.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.user.User;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findOrdersByUser(User user);

	@Query(value = "SELECT * FROM orders WHERE user_id = :user_id ORDER BY CREATED_AT DESC", nativeQuery = true)
	List<Order> orderListByNewer(@Param("user_id") String userId);

	@Query(value = "SELECT * FROM orders WHERE user_id = :user_id ORDER BY CREATED_AT ASC", nativeQuery = true)
	List<Order> orderListByOlder(@Param("user_id") String userId);
	 
	
}
