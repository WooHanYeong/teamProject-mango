package com.itwill.jpa.service.product;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.dao.product.ProductDao;
import com.itwill.jpa.dto.product.GoodsDto;
import com.itwill.jpa.dto.product.ProductCategoryDto;
import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.dto.product.TicketDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.ProductCategory;
import com.itwill.jpa.entity.product.Product.Goods;
import com.itwill.jpa.entity.product.Product.Membership;
import com.itwill.jpa.entity.product.Product.Music;
import com.itwill.jpa.entity.product.Product.Ticket;



@Service
@Transactional(readOnly = true)
//@RequiredArgsConstructor
public interface ProductService{
	
	@Transactional
//Product//	
	Product getProduct(Long productNo); 
	
//	ProductDto getProductDto(Long productNo);

	List<Product> productList(); 
	
	List<Product> getProductsByCategory(Long categoryId);
	
//	List<ProductDto> getProductsByCategorysDtos(Long categoryId);
	
	//전체 product 출력[DTO]	
	List<ProductDto> productDtoList();
	
    // 카테고리 ID를 사용하여 상품 조회 메서드
	List<ProductDto> getProductsByCategoryDto(Long categoryId);
	
//ProductCategory//		
    void saveProductCategory(ProductCategoryDto productCategoryDto);
	

	// 좋아요 누르기 기능[성공]
	Long checkLikeService(Long productNo);

	// 품절 안내 기능[성공]
	Product outOfStockMsg(Long productNo);
	
	/******************** productNo 찾기[ENTITY] ********************/	
	// productNo 찾기[성공]
	public Optional<Product> findByProductNo(Long productNo);
	/******************** productNo 찾기[DTO] ********************/	
	// productNo 찾기 - DTO
	Optional<ProductDto> findProductDtoByProductNo(Long productNo);

	/******************** INSERT[ENTITY] ********************/
	// product 등록[성공]
//	public Product insertProduct(Product product);	
	
	// music 등록[성공]
	public Music insertMusic(Music music);
	
	// goods 등록[성공]
	public Goods insertGoods(Goods goods);
	
	// ticket 등록[성공]
	public Ticket insertTicket(Ticket ticket);
	
	// membership 등록[성공]
	public Membership insertMembership(Membership membership);
	
	/******************** INSERT[DTO] ********************/
	// goods 등록 - DTO[성공]
	GoodsDto insertGoodsDto(GoodsDto goodsDto);
		
	// ticket 등록 - DTO[성공]	
	TicketDto insertTicketDto(TicketDto ticketDto);
	
	/*********************************************/

	/******************** DELETE[ENTITY] ********************/
	// product 삭제[성공]		
	void deleteProduct(Long productNo) throws Exception;
		
	// product 삭제[성공]
//	public void deleteProduct2(Long productNo);
	
	/******************** DELETE[DTO] ********************/
	// product 삭제 - DTO[성공햇다 실패됨]
	ProductDto deledtProductDto(Long productNo) throws Exception;
	
	/*********************************************/
	
	/******************** UPDATE[ENTITY] ********************/	
	// product 업데이트[성공]
	public Product updateProduct(Product product);
	
	// product 업데이트 - DTO	
	ProductDto updateProductDto(ProductDto dto) throws Exception;
	
	// goods 업데이트 - DTO
	GoodsDto updateGoodsDto(GoodsDto goodsDto) throws Exception;
	
	// ticket 업데이트 - DTO
	TicketDto updateTicketDto(TicketDto ticketDto) throws Exception;
	/*********************************************/
	
	/******************** INCREASE READCOUNT[ENTITY] ********************/	
	// product 조회수 올리기[성공]
	Product increaseReadCount(Product product);
	
	/******************** INCREASE READCOUNT[DTO] ********************/
	ProductDto increaseProductReadCountDto(ProductDto productDto) throws Exception;
	
	// goods 조회수 올리기 - DTO
	GoodsDto increaseGoodsReadCountDto(GoodsDto goodsDto) throws Exception;

	// ticket 조회수 올리기 - DTO
	TicketDto increaseTicketReadCountDto(TicketDto ticketDto) throws Exception;
	/*************************************************************/

	/******************** 내림차순[ENTITY] ********************/		
	// product 조회수별 내림차순 정렬 [성공]
	public List<Product> getProductOrderByReadCountDesc();
	
	/******************** 내림차순[DTO] ********************/		
	// product 조회수별 내림차순 정렬 - DTO	[성공]
	List<ProductDto> productByReadCountDescDto(Long categoryId) throws Exception;
	
	/*********************************************/	
	
	/******************** 오름차순[ENTITY] ********************/		
	// product 조회수별 오름차순 정렬 [성공]
	public List<Product> getProductOrderByReadCountAsc();
	
	/******************** 오름차순[DTO] ********************/		
	// product 조회수별 내림차순 정렬 - DTO	[성공]
	List<ProductDto> productByReadCountAscDto(Long categoryId) throws Exception;
	
	/*********************************************/	
	
	/******************** 키워드로 검색[ENTITY] ********************/	
	// 키워드로 검색[성공]
	public List<Product> searchProductsByKeyword(String keyword);
	/******************** 키워드로 검색[DTO] ********************/	
	/*********************************************/	

	/******************** categoryId별로 전체나열[ENTITY] ********************/		
	// product categoryId별 분류
	public List<Product> findByCategoryId(Long categoryId);
	
	/******************** categoryId별로 전체나열[DTO] ********************/		
	// product categoryId별로 전체나열 - DTO	
	List<ProductDto> findByProductCategoryId(Long categoryId);
		
	// ticket categoryId별로 전체나열 - DTO	
	List<TicketDto> findTicketByCategoryId(Long categoryId);
		
	// goods categoryId별로 전체나열 - DTO	
	List<GoodsDto> findGoodsByCategoryId(Long categoryId);
	/*********************************************/	
	
	// product category별 분류
//	List<Product> findByProductCategory(ProductCategory categoryId);
	




	/******************** UPDATE[DTO] ********************/

	
//	// productName 찾기
//	public Product findByProductName(String productName);
//	
//	// productArtist 찾기
//	public Product findByProductAtrist(String productArtist);

	/******************** INCREASE READCOUNT[DTO] ********************/

	
}
