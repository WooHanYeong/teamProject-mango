package com.itwill.jpa.service.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.product.ProductRepository;

class ProductServiceImplTest2 extends TeamProjectMangoApplicationTest{
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductService productService;
	
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void checkLikeServiceTest() {
		System.out.println(productService.checkLikeService(1L));
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void outOfStockTest() { 
		System.out.println(productService.outOfStockMsg(1L));
	}

}
