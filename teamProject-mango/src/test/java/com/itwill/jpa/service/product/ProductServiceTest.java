package com.itwill.jpa.service.product;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.ProductCategory;
import com.itwill.jpa.repository.product.ProductCategoryRepository;
import com.itwill.jpa.repository.product.ProductRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

class ProductRepositoryTest extends TeamProjectMangoApplicationTest{
   @PersistenceContext
   EntityManager em;
   @Autowired
   ProductRepository productRepository;
  
   /*
   @Autowired
   ProductCategoryRepository categoryRepository;
   */
   /*
   @Test
   @Transactional
   @Rollback(false)
   @Disabled
   void productInsertTest() {
      
      ProductCategory productCategory1 = ProductCategory.builder()
    		  											.productCategoryName("music")
    		  											.build();
      ProductCategory productCategory2 = ProductCategory.builder()
    		  											.productCategoryName("goods")
    		  											.build();
      ProductCategory productCategory3 = ProductCategory.builder()
    		  											.productCategoryName("ticket")
    		  											.build();
      ProductCategory productCategory4 = ProductCategory.builder()
    		  											.productCategoryName("membership")
    		  											.build();
      Product product1= Product.builder()
            .productCategory(productCategory1)
            .productName("아름다운사실")
            .productContent("명곡입니다.")
            .productStar(5)
            .productArtist("부활")
            .build();
      em.persist(product1);
      
      Product product2= Product.builder()
            .productCategory(productCategory1)
            .productName("강남스타일")
            .productContent("인기곡입니다.")
            .productStar(4)
            .productArtist("싸이")
            .build();
      em.persist(product2);
      
      Product product3= Product.builder()
            .productCategory(productCategory3)
            .productName("로마네스크")
            .productContent("숨겨진 명곡입니다.")
            .productStar(4)
            .productArtist("쏜애플")
            .build();
      em.persist(product3);
      
      Product product4= Product.builder()
            .productCategory(productCategory4)
            .productName("강북멋쟁이")
            .productContent("신납니다.")
            .productStar(3)
            .build();
      em.persist(product4);

      
      
   }
   */
  

}