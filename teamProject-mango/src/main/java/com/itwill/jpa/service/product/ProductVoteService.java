package com.itwill.jpa.service.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itwill.jpa.entity.product.Product;

public interface ProductVoteService {

	// Vote 대상 뽑기 --> 20위 뽑기
	List<Product> findbyTop20ByTotalScore();

	
//	Product findByProductByVoteId(Long voteNo);

}
