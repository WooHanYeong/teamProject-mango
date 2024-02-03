package com.itwill.jpa.dto.product;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

public class TicketDto {
	
	private String productName;  // 프로덕트(티켓) 이름
	
	private int productPrice; // 프로덕트(티켓) 가격
	
	private Long readCount; // 조회수
	
	private String productContent; // 프로덕트(티켓) 설명
	
	private int productStar; // 프로덕트(티켓) 별점
	
	private Date productDate; // 프로덕트(티켓) 등록날짜
	
	private int productStock; // 프로덕트(티켓) 재고
	
	private String productAddress; // 프로덕트(티켓) 장소
	
	private String productImage; // 프로덕트(티켓) 이미지
	
	/*=============== ProductCategoryId 주입을 위한 Dto와 매서드 ===============*/
    private ProductCategoryDto productCategory;
    
	public ProductCategoryDto getProductCategory() {
		return productCategory;
	}
    public void setProductCategory(ProductCategoryDto productCategory) {
        this.productCategory = productCategory;
    }
    /*=================================================================*/
    
	//Dto에서 보여주는 ticket 정보가 무엇인지 설정하는 생성자(초기화)
	public TicketDto(Ticket ticket) {
		this.productName = ticket.getProductName();
		this.productPrice = ticket.getProductPrice();
		this.readCount = ticket.getReadCount();
		this.productContent = ticket.getProductContent();
		this.productStar = ticket.getProductStar();
		this.productDate = ticket.getProductDate();
		this.productStock = ticket.getProductStock();
		this.productAddress = ticket.getProductAddress();
		this.productImage = ticket.getProductImage();
	}
	
	//Entity to Dto 변환
	public static TicketDto toDto(Ticket entity) {
		return TicketDto.builder()
				.productName(entity.getProductName())
				.productPrice(entity.getProductPrice())
				.readCount(entity.getReadCount())
				.productContent(entity.getProductContent())
				.productStar(entity.getProductStar())
				.productDate(entity.getProductDate())
				.productStock(entity.getProductStock())
				.productAddress(entity.getProductAddress())
				.productImage(entity.getProductImage())
				.build();
	}	
	//List<Entity> to List<Dto> 변환
	public static List<TicketDto> toDto(List<Ticket> entities) {
		List<TicketDto> ticketDtoList = new ArrayList<>();
		 for(Ticket entity : entities) {
			 TicketDto ticketDto = TicketDto.builder()
						.productName(entity.getProductName())
						.productPrice(entity.getProductPrice())
						.readCount(entity.getReadCount())
						.productContent(entity.getProductContent())
						.productStar(entity.getProductStar())
						.productDate(entity.getProductDate())
						.productStock(entity.getProductStock())
						.productAddress(entity.getProductAddress())
						.productImage(entity.getProductImage())
						.build();
			 ticketDtoList.add(ticketDto);
		 }
		 return ticketDtoList;
	}
	
}
