package com.itwill.jpa.dao.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.repository.product.ProductRepository;
import com.itwill.jpa.service.product.ProductServiceImpl;
import com.itwill.jpa.service.vote.VoteServiceImpl;

public class ProductVoteDaoImpl implements ProductVoteDao{
	@Autowired
	ProductServiceImpl productServiceImpl;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private VoteServiceImpl voteServiceImpl;
	
	@Override
	public List<Product> findTop20ByTotalScore() {
		List<Product> productListTop20ByTotalScore 
		= productRepository.findTop20ByTotalScore();
		
		// product Top 20개 추출
	    if (productListTop20ByTotalScore.size() > 20) {
	        productListTop20ByTotalScore = productListTop20ByTotalScore.subList(0, 20);
	    }
	    // product Top 20에 의 사이즈에 맞는 voteId를 설정
	    for (int i = 0; i < productListTop20ByTotalScore.size(); i++) {
	        Product product = productListTop20ByTotalScore.get(i);
	       
	        Vote vote;
	        
			try {
				vote = voteServiceImpl.selectByVoteNo((long) (i));
				product.setVote(vote);
			} catch (Exception e) {
				e.printStackTrace();
			}
			productServiceImpl.updateProduct(product);
	    }
	    
		return productListTop20ByTotalScore;
	}
	
}