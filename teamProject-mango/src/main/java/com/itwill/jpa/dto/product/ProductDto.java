package com.itwill.jpa.dto.product;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.Product.Goods;
import com.itwill.jpa.entity.product.Product.Membership;
import com.itwill.jpa.entity.product.Product.Music;
import com.itwill.jpa.entity.product.Product.Ticket;
import com.itwill.jpa.entity.product.ProductCategory;

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
public class ProductDto {
	
	private Long productNo;
	
	private Long productCategoryId; // 프로덕트 카테고리
	 	
	private String productName;  // 프로덕트 이름
	
	private int productPrice; // 프로덕트 가격
	
	private Long readCount; // 조회수
	
	private String productContent; // 프로덕트(음악,굿즈,티켓) 설명
	
	private int productStar; // 프로덕트(음악,굿즈,티켓) 별점
	
	private Date productDate; // 프로덕트(음악,굿즈,티켓) 등록날짜
	
	private int productStock; // 프로덕트(굿즈, 티켓) 재고
	
	private String productMovie; // 음악 뮤직비디오

	private String productArtist; // 음악 아티스트
	
	private String productAddress; // 티켓 장소
	
	private Date startPeriod; // 멤버십 시작날짜
	
	private int periodOfUse; // 멤버십 사용기간
	
	private String productImage; // 프로덕트(음악,굿즈,티켓,멤버십) 이미지
	private List<Product> products;
	private List<Music> musics;
	private List<Goods> goodss;
	private List<Ticket> tickets;
	private List<Membership> memberships;
	
	
public ProductDto(Product product) {
	this.productCategoryId = product.getProductCategory().getCategoryId();
	this.productNo = product.getProductNo();
	this.productName = product.getProductName();
	this.productPrice = product.getProductPrice();
	this.productContent = product.getProductContent();
	this.productStar = product.getProductStar();
	this.productDate = product.getProductDate();
	this.readCount = product.getReadCount();
	this.productStock = product.getProductStock();
	this.productImage = product.getProductImage();
	this.productArtist = product.getProductArtist();
	this.productAddress = product.getProductAddress();
	this.startPeriod = product.getStartPeriod();
	this.periodOfUse = product.getPeriodOfUse();

	}
//Entity to Dto 변환
public static ProductDto toDto(Product entity) {
	ProductDto productDto = ProductDto.builder()
										.productNo(entity.getProductNo())
										.productName(entity.getProductName())
										.productPrice(entity.getProductPrice())
										.productContent(entity.getProductContent())
										.productStar(entity.getProductStar())
										.productDate(entity.getProductDate())
										.readCount(entity.getReadCount())
										.productStock(entity.getProductStock())
										.productImage(entity.getProductImage())
										.productArtist(entity.getProductArtist())
										.productAddress(entity.getProductAddress())
										.startPeriod(entity.getStartPeriod())
										.periodOfUse(entity.getPeriodOfUse())
										.build();
	return productDto;
}
//List<Entity> to List<Dto> 변환
	public static List<ProductDto> toDto(List<Product> entities) {
		List<ProductDto> productDtoList = new ArrayList<>();
		 for(Product entity : entities) {
			 ProductDto productDto = ProductDto.builder()
					 	.productNo(entity.getProductNo())
						.productName(entity.getProductName())
						.productPrice(entity.getProductPrice())
						.productContent(entity.getProductContent())
						.productStar(entity.getProductStar())
						.productDate(entity.getProductDate())
						.readCount(entity.getReadCount())
						.productStock(entity.getProductStock())
						.productImage(entity.getProductImage())
						.productArtist(entity.getProductArtist())
						.productAddress(entity.getProductAddress())
						.startPeriod(entity.getStartPeriod())
						.periodOfUse(entity.getPeriodOfUse())
						.build();
			 productDtoList.add(productDto);
	 }
		 return productDtoList;
}
	}

