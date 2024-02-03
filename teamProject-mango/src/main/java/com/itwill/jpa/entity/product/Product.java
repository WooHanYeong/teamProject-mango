package com.itwill.jpa.entity.product;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.itwill.jpa.dto.product.GoodsDto;
import com.itwill.jpa.dto.product.ProductCategoryDto;
import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.dto.product.TicketDto;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.exception.product.NotEnoughProductStockException;
import com.itwill.jpa.repository.product.ProductCategoryRepository;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder //Dto를 Entity로 변환하는 메서드를 쓰기위해서 사용
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product {
	@Id
	@SequenceGenerator(name = "PRODUCT_PRODUCT_NO_SEQ", sequenceName = "PRODUCT_PRODUCT_NO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_PRODUCT_NO_SEQ")
	@Column(name = "product_no")

	/*==================멤버필드==================*/
	private Long productNo; // PK

	@Column(nullable = false)
	private String productName;
	@Column(nullable = false)
	private int productPrice;

	// @SequenceGenerator(name = "PRODUCT_PRODUCT_STAR_SEQ" , sequenceName =
	// "PRODUCT_PRODUCT_STAR_SEQ", initialValue = 0 , allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "PRODUCT_PRODUCT_STAR_SEQ")
	private int productStar; // 프로덕트(음악,굿즈,콘서트) 별점

	private String productContent; // 프로덕트(음악,굿즈,콘서트) 설명
	private Date productDate; // 프로덕트(음악,굿즈,콘서트) 등록날짜
	private Long readCount; // 프로덕트(음악,콘서트) 조회수
	private int productStock; // 프로덕트(굿즈, 티켓) 재고
	private String productImage; // 프로덕트(음악,굿즈,콘서트,멤버십) 등록날짜
	private String productMovie; // 음악 뮤직비디오
	private String productArtist; // 음악 아티스트
	private String productAddress; // 콘서트 장소
	private Date startPeriod; // 멤버십 시작날짜
	private int periodOfUse; // 멤버십 사용기간

	/** music **/

	@Entity
	@DiscriminatorValue("music")
	public static class Music extends Product {
	}

	/** goods **/
	@Entity
	@DiscriminatorValue("goods")
	public static class Goods extends Product {
		/*============Dto -> entity 변환해주는 매서드============*/		
		public static Goods toEntity(GoodsDto goodsDto) {
			ProductCategoryDto productCategoryDto = goodsDto.getProductCategory();
			ProductCategory productCategory = productCategoryDto.toEntity(); // ProductCategoryDto를 ProductCategory 엔티티로 변환
		    Goods goods = new Goods();
		    // GoodsDto에서 Goods 엔티티로 필드 값을 복사 또는 초기화
		    goods.setProductCategory(productCategory);
		    goods.setProductName(goodsDto.getProductName());
		    goods.setProductPrice(goodsDto.getProductPrice());
		    goods.setProductStar(goodsDto.getProductStar());
		    goods.setProductDate(goodsDto.getProductDate());
		    goods.setReadCount(goodsDto.getReadCount());
		    goods.setProductStock(goodsDto.getProductStock());
		    goods.setProductImage(goodsDto.getProductImage());
		    return goods;
	}
	}
	
	/** ticket **/
	@Entity
	@DiscriminatorValue("ticket")
	public static class Ticket extends Product {
		/*============Dto -> entity 변환해주는 매서드============*/		
		public static Ticket toEntity(TicketDto ticketDto) {
			ProductCategoryDto productCategoryDto = ticketDto.getProductCategory();
			ProductCategory productCategory = productCategoryDto.toEntity(); // ProductCategoryDto를 ProductCategory 엔티티로 변환
		    Ticket ticket = new Ticket();
		    // GoodsDto에서 Goods 엔티티로 필드 값을 복사 또는 초기화
		    ticket.setProductCategory(productCategory);
		    ticket.setProductName(ticketDto.getProductName());
		    ticket.setProductPrice(ticketDto.getProductPrice());
		    ticket.setProductStar(ticketDto.getProductStar());
		    ticket.setProductDate(ticketDto.getProductDate());
		    ticket.setReadCount(ticketDto.getReadCount());
		    ticket.setProductStock(ticketDto.getProductStock());
		    ticket.setProductImage(ticketDto.getProductImage());
		    return ticket;
	}
	}

	/** membership **/
	@Entity
	@DiscriminatorValue("membership")
	public static class Membership extends Product {
	}
	/*============================================*/
		
	/*/////////////////////////매서드/////////////////////////*/
	
	/*==================관게설정==================*/
	//1대N 관계설정
	@ManyToOne
	@JoinColumn(name = "vote_id")
	@ToString.Exclude
	private Vote vote;
	
	// product와 orderitem 1대n
	@OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
	@Builder.Default
	@ToString.Exclude
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	// product와 productcategory n대1
	@ManyToOne
	@JoinColumn(name = "product_category_id")
	@ToString.Exclude
	
	private ProductCategory productCategory;

	// product와 cartitem 1대n
	@OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
	@Builder.Default
	@ToString.Exclude
	private List<CartItem> cartitems = new ArrayList<CartItem>();
	
	// product와 productreply 1대n
	@OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
	@Builder.Default
	@ToString.Exclude
	private List<ProductReply> productReply = new ArrayList<>();

	/*============================================*/
	
	/*============Dto -> entity 변환해주는 매서드============*/

	public static Product toEntity(ProductDto dto) {
	    ProductCategory productCategory = ProductCategory.builder()
	            .categoryId(dto.getProductCategoryId()) // Long 값을 그대로 사용
	            .build();
		return Product.builder()
				.productCategory(productCategory)
				.productName(dto.getProductName())
				.productPrice(dto.getProductPrice())
				.productStar(dto.getProductStar())
				.productDate(dto.getProductDate())
				.readCount(dto.getReadCount())
				.productStock(dto.getProductStock())
				.productImage(dto.getProductImage())
				.productMovie(dto.getProductMovie())
				.productArtist(dto.getProductArtist())
				.productAddress(dto.getProductAddress())
				.startPeriod(dto.getStartPeriod())
				.periodOfUse(dto.getPeriodOfUse())
				.build();
	}
	/*=======================================================*/
	
	/*============================================*/
	
	// ---- 비즈니스 로직----//
	/* productStock 증가 */
	public void addproductStock(int quantity) {
		this.productStock += quantity;
	}
	
	/* productStock 감소 */
	public void removeproductStock(int quantity) {
		int restproductStock = this.productStock - quantity;
		if (restproductStock < 0) {
			throw new NotEnoughProductStockException("품절입니다.");
		}
		this.productStock = restproductStock;
	}

//	public String setProductCategory(ProductCategory productCategory) {
//		return productCategory.getProductCategoryName();
//		
//	}
//	public Long setCategoryId(Long categoryId) {
//		return productCategory.getCategoryId();
//		
//	}
    public void setCategoryId(Long categoryId) {
        // Product 클래스의 setProductCategory 메서드 호출
        setProductCategory(new ProductCategory(categoryId, "Music", null));
    }

	}
	
