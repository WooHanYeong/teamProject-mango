package com.itwill.jpa.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.dto.product.ProductCategoryDto;
import com.itwill.jpa.entity.product.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {




}
