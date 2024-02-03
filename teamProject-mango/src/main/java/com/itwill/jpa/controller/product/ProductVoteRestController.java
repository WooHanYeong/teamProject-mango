//package com.itwill.jpa.controller.product;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.itwill.jpa.dto.product.ProductVoteDto;
//import com.itwill.jpa.dto.vote.VoteDto;
//import com.itwill.jpa.entity.product.Product;
//import com.itwill.jpa.entity.vote.Vote;
//import com.itwill.jpa.service.product.ProductVoteServiceImple;
//import com.itwill.jpa.service.vote.VoteService;
//import com.itwill.jpa.service.vote.VoteServiceImpl;
//
//import io.swagger.v3.oas.annotations.Operation;
//
//@RestController
//@RequestMapping("/") // 매핑명은 임의로 한거라 추후 수정예정입니당
//public class ProductVoteRestController {
//
//	@Autowired
//	private VoteServiceImpl voteServiceImpl;
//	
//	@Autowired
//	private ProductVoteServiceImple productVoteServiceImple;
//	
//	@Operation(summary = "투표번호로 상품 보기") 
//	@PostMapping("/selectProduct{voteId}")
//	public ResponseEntity<ProductVoteDto> selectVote(@PathVariable(name = "voteId") Long voteId) throws Exception {
//		 Vote vote = voteServiceImpl.selectByVoteNo(voteId);
//		 Product product = productVoteServiceImple.findByVoteVoteId(vote.getVoteId());
//		 ProductVoteDto selectVote = ProductVoteDto.toDto(product);
//		 return ResponseEntity.status(HttpStatus.OK).body(selectVote);
//		 
//	}
//}
