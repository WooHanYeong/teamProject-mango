package com.itwill.jpa.entity.product;

import java.util.ArrayList;
import java.util.List;

import com.itwill.jpa.dto.product.ProductCategoryDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "product_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategory {
   
 @Id 
 @Column(name = "category_id")
 @SequenceGenerator(name = "PRODUCT_CATEGORY_NO_SEQ",sequenceName = "PRODUCT_CATEGORY_NO_SEQ",initialValue = 1 , allocationSize =1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_CATEGORY_NO_SEQ")
 
	/*==================멤버필드==================*/
 private Long categoryId;
 private String productCategoryName;
	/*============================================*/

	/*/////////////////////////매서드/////////////////////////*/
 
	/*==================관게설정==================*/ 

 //productcategory와 product -> 1:n관계
	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.PERSIST)
	@Builder.Default
	@ToString.Exclude
	private List<Product> products = new ArrayList<Product>();
	/*============================================*/
	
	/*============Dto -> entity 변환해주는 매서드============*/
	 public static ProductCategory toEntity(ProductCategoryDto dto) {
		 return ProductCategory.builder()
				 				.categoryId(dto.getCategoryId())
				 			   .productCategoryName(dto.getProductCategoryName())
				 			   .build();
	 }
//	public ProductCategory toEntity() {
//	    return ProductCategory.builder()
//	            .categoryId(this.getCategoryId())
//	            .productCategoryName(this.getProductCategoryName())
//	            .build();
//	}
	/*========================================================*/	
	 private ProductCategory convertDtoToEntity(ProductCategoryDto productCategoryDto) {
		    ProductCategory productCategory = ProductCategory.builder()
		            .categoryId(productCategoryDto.getCategoryId())
		            .productCategoryName(productCategoryDto.getProductCategoryName())
		            .build();

		    // 이 부분에서 연관 엔티티나 추가 작업이 필요하다면 이어서 작성합니다.

		    return productCategory;
		}
}