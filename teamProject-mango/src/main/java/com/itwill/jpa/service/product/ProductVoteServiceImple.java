package com.itwill.jpa.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.product.ProductDao;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.product.ProductRepository;

@Service
public class ProductVoteServiceImple implements ProductVoteService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	ProductDao productDao;
	
	
	// 완료
	@Override
	public List<Product> findbyTop20ByTotalScore() {
		List<Product> findTop20ByTotalScore = productRepository.findTop20ByTotalScore(); 	
		return findTop20ByTotalScore;
	}


//	@Override
//	public Product findByProductByVoteId(Long voteNo) {
//		Product findByProductByVoteId = productRepository.findByProductByVoteId(voteNo);
//		return findByProductByVoteId;
//	}


}
