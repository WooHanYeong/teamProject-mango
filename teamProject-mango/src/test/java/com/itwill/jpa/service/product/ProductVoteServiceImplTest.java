package com.itwill.jpa.service.product;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.repository.product.ProductRepository;

class ProductVoteServiceImplTest extends TeamProjectMangoApplicationTest{
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductVoteServiceImple productVoteServiceImple;
	

	/******************* Vote  ***********************/

		@Test
		@Transactional
		@Rollback(false)
		@Disabled
		// 상품에서 음악 조회수(readCount), 음악 별점(productStar)의 합산해서 Top 20명 추출
		public void testfindTop20ByTotalScore() {
		
			System.out.println(">>>>>>>>>>"+productVoteServiceImple.findbyTop20ByTotalScore());
			
			//System.out.println(">>>>>>>>>>"+productRepository.findByProductVoteId(1L));
			
		}
		
	
//		@Transactional
//		@Rollback(false)
//		@ParameterizedTest
//		@Disabled
//		public void testfindByProductByVoteId(Long voteNO) {
//		    System.out.println(">>>>>>>>>>" + productVoteServiceImple.findByProductByVoteId(1L));
//		}
}
