package com.itwill.jpa.dto.product;

import java.sql.Date;
import java.util.List;

import com.itwill.jpa.dto.vote.VoteDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.ProductCategory;
import com.itwill.jpa.entity.product.Product.Goods;
import com.itwill.jpa.entity.product.Product.Membership;
import com.itwill.jpa.entity.product.Product.Music;
import com.itwill.jpa.entity.product.Product.Ticket;
import com.itwill.jpa.entity.vote.Vote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductVoteDto {

	private String productName;
	private int productStar; // 프로덕트(음악,굿즈,콘서트) 별점
	private String productContent; // 프로덕트(음악,굿즈,콘서트) 설명
	private Date productDate; // 프로덕트(음악,굿즈,콘서트) 등록날짜
	private Long readCount; // 프로덕트(음악,콘서트) 조회수
	private String productImage; // 프로덕트(음악,굿즈,콘서트,멤버십) 등록날짜
	private String productArtist; // 음악 아티스트
	
	private Long voteId;	
	private Date voteDate; 			
	private int voteTot;
	
	public ProductVoteDto(Product product, Vote vote) {
		
		this.productName = product.getProductName();
		this.productStar = product.getProductStar();
		this.productContent = product.getProductContent();
		this.productDate = product.getProductDate();
		this.readCount = product.getReadCount();
		this.productImage = product.getProductImage();
		this.productArtist = product.getProductArtist();
		this.voteId = vote.getVoteId();
		this.voteDate = vote.getVoteDate();
		this.voteTot = vote.getVoteTot();
	} 	
	
	
	public static ProductVoteDto toDto(Product entity) {
		return ProductVoteDto.builder()
			.productName(entity.getProductName())
			.productContent(entity.getProductContent())
			.productStar(entity.getProductStar())
			.productDate(entity.getProductDate())
			.readCount(entity.getReadCount())
			.productImage(entity.getProductImage())
			.productArtist(entity.getProductArtist())
			.voteId(entity.getVote().getVoteId())
			.build();
		
	}
	
	public static ProductVoteDto toDto(Product product, Vote vote) {
	    return ProductVoteDto.builder()
	            .productName(product.getProductName())
	            .productContent(product.getProductContent())
	            .productStar(product.getProductStar())
	            .productDate(product.getProductDate())
	            .readCount(product.getReadCount())
	            .productImage(product.getProductImage())
	            .productArtist(product.getProductArtist())
	            .voteId(vote.getVoteId())
	            .voteDate(vote.getVoteDate())
	            .voteTot(vote.getVoteTot())
	            .build();
	}
	
}