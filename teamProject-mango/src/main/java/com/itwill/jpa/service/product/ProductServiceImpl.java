package com.itwill.jpa.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.dao.product.ProductDao;
import com.itwill.jpa.dto.product.GoodsDto;
import com.itwill.jpa.dto.product.ProductCategoryDto;
import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.dto.product.TicketDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.Product.Goods;
import com.itwill.jpa.entity.product.Product.Membership;
import com.itwill.jpa.entity.product.Product.Music;
import com.itwill.jpa.entity.product.Product.Ticket;
import com.itwill.jpa.entity.product.ProductCategory;
import com.itwill.jpa.exception.product.NotEnoughProductStockException;
import com.itwill.jpa.repository.product.ProductCategoryRepository;
import com.itwill.jpa.repository.product.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	@Autowired
	ProductDao productDao;
	
	// productId값 가져오기		
	@Override
	public Product getProduct(Long productNo) {
		return productRepository.findById(productNo).get();
	}
//	@Override
//	public ProductDto getProductDto(Long productNo) {
//		return productRepository.findByIdDto(productNo).get();
//	}
	
	// categoryId값 가져오기	
	@Override	
	public List<Product> getProductsByCategory(Long categoryId) {
		return productRepository.findByProductCategoryCategoryId(categoryId);
	}
//	@Override
//	public List<ProductDto> getProductsByCategorysDtos(Long categoryId) {
//		return productRepository.findBy;
//	}
	@Override
	public List<Product> productList() {
		return productRepository.findAll();
	}
	/*
	 * @Override public Product saveProduct(Product product) { return
	 * productRepository.save(product); }
	 */
	
	//전체 product 출력[DTO]
	@Override
	public List<ProductDto> productDtoList() {
		List<Product> productList = productRepository.findAll();
		List<ProductDto> productDtoList = new ArrayList<ProductDto>();
		for(Product product : productList) {
			productDtoList.add(ProductDto.toDto(product));
		}
		return productDtoList;
	}
		
	// 좋아요 누르기 기능[성공]
	@Override
	public Long checkLikeService(Long productNo) {
		Product findProduct = productRepository.findById(productNo).get();
		Long checkLike = Long.valueOf(findProduct.getProductStar());
		if(checkLike%2==1) {
			checkLike=1L;
		}else if(checkLike%2==0) {
			checkLike=0L;
		}
		return checkLike;
	}
	
	// 품절 안내 기능[성공]
	@Override
	   public Product outOfStockMsg(Long productNo) {
	      Product findProduct =productRepository.findById(productNo).get();
	      String msg="";
	      int stockCount=findProduct.getProductStock();
	      
	      if(stockCount==0) {
	         throw new NotEnoughProductStockException("품절된 상품입니다.");
	      }else {
	         msg=stockCount+"개 남았습니다.";
	      }
	      System.out.println(msg);
	      return null;
	   }
/******************** productNo 찾기[ENTITY] ********************/
	// productNo 찾기[성공]	
	@Override
	public Optional<Product> findByProductNo(Long productNo) {
		return productRepository.findById(productNo);
	}	
/******************** productNo 찾기[DTO] ********************/
	// productNo 찾기[성공]	
	@Override
	public Optional<ProductDto> findProductDtoByProductNo(Long productNo) {
	    Optional<Product> productOptional = productRepository.findById(productNo);
	    if (productOptional.isPresent()) {
	        Product product = productOptional.get();
	        ProductDto productDto = ProductDto.toDto(product);
	        return Optional.of(productDto);
	    } else {
	        return Optional.empty();
	    }
	}	
/*************************************************************************/	
	
/******************** categoryId별로 전체나열[ENTITY] ********************/
	
	// product 카테고리별 구분[성공]
//	@Override
//	public List<Product> findByProductCategory(ProductCategory categoryId) {
//		return productRepository.findByProductCategory(categoryId);
//	}
/*************************************************************************/	
	@Override
	public List<Product> findByCategoryId(Long categoryId) {
		return productRepository.findByProductCategoryCategoryId(categoryId);
	}
/******************** categoryId별로 전체나열[DTO] ********************/
		
	// product categoryId별로 전체나열 - DTO [성공]
	@Override
	public List<ProductDto> findByProductCategoryId(Long categoryId) {
		List<Product> productList = productDao.getProductByCategoryId(categoryId);
		List<ProductDto> productDtoList = new ArrayList<ProductDto>();
		for (Product product : productList) {
			productDtoList.add(ProductDto.toDto(product));
		}
		return productDtoList;
	}
	// goods categoryId별로 전체나열 - DTO [성공]
	@Override
	public List<GoodsDto> findGoodsByCategoryId(Long categoryId) {
		List<Goods> goodsList = productDao.getGoodsByCategoryId(categoryId);
		List<GoodsDto> goodsDtoList = new ArrayList<GoodsDto>();
		for (Goods goods : goodsList) {
			goodsDtoList.add(GoodsDto.toDto(goods));
		}
		return goodsDtoList;
	}
	// ticket categoryId별로 전체나열 - DTO [성공]
	@Override
	public List<TicketDto> findTicketByCategoryId(Long categoryId) {
		List<Ticket> ticketList = productDao.getTicketByCategoryId(categoryId);
		List<TicketDto> ticketDtoList = new ArrayList<TicketDto>();
		for (Ticket ticket : ticketList) {
			ticketDtoList.add(TicketDto.toDto(ticket));
		}
		return ticketDtoList;
	}	
/*********************************************/	
    public void saveProductCategory(ProductCategoryDto dto) {
        ProductCategory productCategory = dto.toEntity();
        productCategoryRepository.save(productCategory);
    }
/******************** insert[ENTITY] ********************/	
	//product 추가[성공]
//	@Override
//	public Product insertProduct(Product product) {
//		return productRepository.save(product);
//	}
	
	//music 추가[성공]
	@Override
	public Music insertMusic(Music music) {
		return productRepository.save(music);
	}
	//goods 추가[성공]
	@Override
	public Goods insertGoods(Goods goods) {
		return productRepository.save(goods);
	}
	//ticket 추가[성공]
	@Override
	public Ticket insertTicket(Ticket ticket) {
		return productRepository.save(ticket);
	}
	//membership 추가[성공]
	@Override
	public Membership insertMembership(Membership membership) {
		return productRepository.save(membership);
	}
	
/******************** INSERT[DTO] ********************/
	
	// goods 등록 - DTO	[성공]
	@Override
	public GoodsDto insertGoodsDto(GoodsDto dto) {
		Goods goods = productRepository.save(Goods.toEntity(dto));
		GoodsDto goodsDto = GoodsDto.toDto(goods);
		return goodsDto;
	}
	
	// ticket 등록 - DTO [성공]
	@Override
	public TicketDto insertTicketDto(TicketDto dto) {
		Ticket ticket = productRepository.save(Ticket.toEntity(dto));
		TicketDto ticketDto = TicketDto.toDto(ticket);
		return ticketDto;
	}
/*********************************************/	
	
/******************** DELETE[ENTITY] ********************/	
	//product 삭제[성공]	
	@Override
	public void deleteProduct(Long productNo) throws Exception {
		productRepository.deleteById(productNo);
		
	}
//	
//	//product 삭제[성공]
//	
//	  @Override
//	  public void deleteProduct2(Long productNo) { 
//		  Optional<Product> productOptional = productRepository.findById(productNo);
//	  if(productOptional.isPresent()) { 
//		  Product product = productOptional.get();
//		  productRepository.delete(product); //product 객체 있으면 꺼내서 삭제
//		  }else {	  
//	  //예외처리
//	  }
//		
//	}
/******************** DELETE[DTO] ********************/	
	  
		// product 삭제 - DTO[성공햇다가 실패됨]
		@Override
		public ProductDto deledtProductDto(Long productNo) throws Exception {
			Product product = productRepository.findById(productNo).orElseThrow(() -> new IllegalArgumentException("제품이 존재하지 않습니다."));
			productRepository.deleteByProductNo(productNo);
			productRepository.deleteById(productNo);
			ProductDto productDto = ProductDto.toDto(product);
			return productDto;
		}		
		/*********************************************/
		
/******************** UPDATE[ENTITY] ********************/
	//product 수정[성공]
	@Override
	public Product updateProduct(Product product) {
		Product isProduct = productRepository.findById(product.getProductNo()).orElse(null);
		if(isProduct != null) {
			isProduct.setProductCategory(product.getProductCategory()); // product 카테고리 수정
			isProduct.setProductName(product.getProductName()); // product 이름 수정
			isProduct.setProductPrice(product.getProductPrice()); // product 가격 수정
			isProduct.setProductStar(product.getProductStar()); // product 좋아요 수정
			isProduct.setProductContent(product.getProductContent()); // product 설명 수정
			isProduct.setProductReply(product.getProductReply()); // product 댓글 수정
			isProduct.setReadCount(product.getReadCount()); // product 조회수 수정
			isProduct.setProductStock(product.getProductStock()); // product 재고 수정
			isProduct.setProductImage(product.getProductImage()); // product 이미지 수정
			isProduct.setProductMovie(product.getProductMovie()); // music 뮤직비디오 수정
			isProduct.setProductArtist(product.getProductArtist()); // product 아티스트 수정
			isProduct.setProductAddress(product.getProductAddress()); // 콘서트 장소 수정
			isProduct.setStartPeriod(product.getStartPeriod()); // membership 시작날짜 수정
			isProduct.setPeriodOfUse(product.getPeriodOfUse()); // membership 사용기간 수정
			return productRepository.save(isProduct); //수정내용 저장
		}else {
			//제품 없으면 예외처리
			throw new EntityNotFoundException("제품을 찾을 수 없습니다.");
		}
	}
/*********************************************/	
	
	// Product를 ProductDto로 변환하는 메서드	
	private ProductDto convertProductToProductDto(Product product) {
		// Product 엔티티의 필드 값을 ProductDto로 복사
		ProductDto productDto = new ProductDto();
		productDto.setProductNo(product.getProductNo());
		productDto.setProductName(product.getProductName());
		// 나머지 필드 복사
		return productDto;
	}
/******************** UPDATE[DTO] ********************/	
	// product 수정 - DTO[실패]
	@Transactional
	@Override
	public ProductDto updateProductDto(ProductDto dto) throws Exception {
	    Product product = productDao.updateProduct(Product.toEntity(dto));
	    ProductDto productDto = ProductDto.toDto(product);
	    return productDto;
//        Long productNo = dto.getProductNo();
//        
//        // 유효성 검사: productNo가 null 또는 0보다 작으면 예외 처리
//        if (productNo == null || productNo <= 0) {
//        	System.out.println("실패란다.");
//    //        throw new IllegalArgumentException("productNo must not be null or less than or equal to 0");
//        }
//        // productNo를 사용하여 Product 엔티티를 찾음
//        Optional<Product> productOptional = productRepository.findById(productNo);
//        if (productOptional.isPresent()) {
//            // Product 엔티티를 찾은 경우, 업데이트 작업 수행
//            Product product = productOptional.get();
//            // productDto의 정보를 사용하여 product 엔티티 업데이트
//            Product updatedProduct = productRepository.save(product);         
//            // Product를 ProductDto로 변환하여 반환
//            ProductDto updatedProductDto = convertProductToProductDto(updatedProduct);
//            return updatedProductDto;
//        } else {
//            // Product 엔티티를 찾지 못한 경우 처리
//        	System.out.println("실패란다.");
//            throw new EntityNotFoundException("Product with productNo " + productNo + " not found");
//        }
	}
	// goods 수정 - DTO
	@Transactional
	@Override
	public GoodsDto updateGoodsDto(GoodsDto dto) throws Exception {
		Goods goods = productDao.updateGoods(Goods.toEntity(dto));
		GoodsDto goodsDto = GoodsDto.toDto(goods);
		return goodsDto;
	}
	
	// ticket 수정 - DTO
	@Override
	public TicketDto updateTicketDto(TicketDto dto) throws Exception {
		Ticket ticket = productDao.updateTicket(Ticket.toEntity(dto));
		TicketDto ticketDto = TicketDto.toDto(ticket);
		return ticketDto;
	}
	/*********************************************/

	
/******************** INCREASE READCOUNT[ENTITY] ********************/	
	// product 조회수 올리기[성공]
	@Override
	public Product increaseReadCount(Product product) {
        // 현재 조회수를 가져와서 1 증가
        Long currentReadCount = product.getReadCount();
        Long newReadCount = currentReadCount + 1L; // 1을 Long으로 캐스팅해서 증가
        
        // 증가된 조회수를 엔티티에 설정
        product.setReadCount(newReadCount);

        // 업데이트된 엔티티를 저장하고 반환
        return productRepository.save(product);
	}
/******************** INCREASE READCOUNT[DTO] ********************/
	// goods 조회수 올리기 - DTO[실패]	
	@Override
	public ProductDto increaseProductReadCountDto(ProductDto productDto) throws Exception {
//		return null;
        // 주어진 productDto에서 productNo를 가져옵니다.
        Long productNo = productDto.getProductNo();
        // productNo를 이용하여 해당 엔티티를 데이터베이스에서 찾습니다.
        Optional<Product> productOptional = productRepository.findById(productNo);

        if (productOptional.isPresent()) {
            // 조회수를 1 증가시킵니다.
        	Product product = productOptional.get();
            product.setReadCount(product.getReadCount() + 1);
            // 변경된 엔티티를 저장합니다.
            productRepository.save(product);
            // 엔티티를 DTO로 변환하여 반환합니다.
            return ProductDto.toDto(product);
        } else {
            throw new Exception("해당 productNo에 해당하는 제품을 찾을 수 없습니다.");
        }
    }
		
	// goods 조회수 올리기 - DTO	
	@Override
	public GoodsDto increaseGoodsReadCountDto(GoodsDto goodsDto) throws Exception {
//		Goods goods = 
		return null;
	}
	
	// ticket 조회수 올리기 - DTO
	@Override
	public TicketDto increaseTicketReadCountDto(TicketDto ticketReadCountDto) throws Exception {
		Ticket ticket = productDao.updateTicket(Ticket.toEntity(ticketReadCountDto));
		
		return null;
	}
    // 카테고리 ID를 사용하여 상품 조회 - DTO
    @Override
    public List<ProductDto> getProductsByCategoryDto(Long categoryId) {
        List<Product> productList = productRepository.findByProductCategoryCategoryId(categoryId);
        List<ProductDto> productDtoList = ProductDto.toDto(productList);
        return productDtoList;
    }	
/******************** 내림차순[ENTITY] ********************/
	
	// product 조회수별 내림차순 정렬[성공]
	public List<Product> getProductOrderByReadCountDesc() {
		Sort sort = Sort.by(Sort.Direction.DESC, "readCount");
		return productRepository.findAll(sort);
	}
	
/******************** 내림차순[DTO][성공] ********************/		
	@Override
	public List<ProductDto> productByReadCountDescDto(Long categoryId) throws Exception {
        // 정렬 기준
        Sort sort = Sort.by(Sort.Direction.DESC, "readCount");
        // categoryId를 사용하여 상품을 조회하고 readCount에 따라 정렬
        List<Product> productList = productRepository.findByProductCategoryCategoryIdOrderByReadCount(categoryId);
        // Product를 ProductDto로 변환
        List<ProductDto> productDtoList = ProductDto.toDto(productList);
        return productDtoList;
	}

/*********************************************/
	
/******************** 오름차순[ENTITY]  ********************/
	
	// product 조회수별 오름차순 정렬[성공]
	public List<Product> getProductOrderByReadCountAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC, "readCount");
		return productRepository.findAll(sort);
	}
	
/******************** 오름차순[DTO] ********************/
	@Override
	public List<ProductDto> productByReadCountAscDto(Long categoryId) throws Exception {
        // 정렬 기준을 설정
        Sort sort = Sort.by(Sort.Direction.DESC, "readCount");

        // categoryId를 사용하여 상품을 조회하고 readCount에 따라 정렬
        List<Product> productList = productRepository.findByProductCategoryCategoryIdOrderByReadCount(categoryId);

        // Product를 ProductDto로 변환
        List<ProductDto> productDtoList = ProductDto.toDto(productList);

        return productDtoList;
	}
	
/*********************************************/	
	//제목키워드로 검색[성공]
	@Override
	public List<Product> searchProductsByKeyword(String keyword) {
		return productRepository.findByProductNameContaining(keyword);
	}
	/*==============================================================*/





		
	/*============================================================*/
	
	/*********************************************/	
	/****************진행중인거****************/	

	// productName 찾기	
//	@Override
//	public Product findByProductName(String productName) {
//		return productRepository.findByProductName(productName);
//	}
	
	// productArtist 찾기
//	@Override
//	public Product findByProductAtrist(String productArtist) {
//		return productRepository.findByProductArtist(productArtist);
//	}

}
