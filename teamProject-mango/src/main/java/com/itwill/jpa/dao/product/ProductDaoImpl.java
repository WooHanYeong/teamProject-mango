package com.itwill.jpa.dao.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.Product.Goods;
import com.itwill.jpa.entity.product.Product.Ticket;
import com.itwill.jpa.entity.product.ProductCategory;
import com.itwill.jpa.repository.product.ProductCategoryRepository;
import com.itwill.jpa.repository.product.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductCategoryRepository productCategoryRepository;

	// 제품 나열
	@Override	
	public List<Product> selectList(){
		return productRepository.findAll();
	}
	
	// 제품 등록
	@Override
	public Product insertProduct(Product product) {
		Product insertProduct = productRepository.save(product);
		return insertProduct;
	}
	@Override
	public Ticket insertTicket(Ticket ticket) {
		Ticket insertTicket = productRepository.save(ticket);
		return insertTicket;
	}
	@Override
	public Goods insertGoods(Goods goods) {
		Goods insertGoods = productRepository.save(goods);
		return insertGoods;
	}
	// 제품 조회
	@Override
	public Product selectProduct(Long productNo) {
		Product selectProduct = productRepository.findById(productNo).get();
		return selectProduct;
	}
	// 제품 업데이트
	@Override
	public Product updateProduct(Product product) throws Exception {
		Optional<Product> findProductOptional = productRepository.findById(product.getProductNo());
		Product updateProduct=null;
		if(findProductOptional.isPresent()) {
			Product findProduct = findProductOptional.get();
			findProduct.setProductName(product.getProductName());
			product=productRepository.save(findProduct);
		}else {
			throw new Exception("존재하지 않는 제품입니다.");
		}
		return updateProduct;
	}
	@Override
	public Goods updateGoods(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Ticket updateTicket(Ticket ticket) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	// 제품 삭제
	@Override
	public void deleteProduct(Long productNo) throws Exception {
		Optional<Product> selectProductOptional= productRepository.findById(productNo);
		if(selectProductOptional.isEmpty()) {
			throw new Exception("존재하지 않는 제품입니다.");
		}
		productRepository.delete(selectProductOptional.get());
	}

	//제품 카테고리별 나열		
	@Override
	public List<Product> getProductByCategoryId(Long categoryId) {
		Optional<ProductCategory> categoryOptional = productCategoryRepository.findById(categoryId);
		if(categoryOptional.isPresent()) {
			ProductCategory productCategory = categoryOptional.get();
			return productRepository.findByProductCategory(productCategory);
		}else {
			return new ArrayList<>();  // 카테고리를 찾지 못한 경우 빈 목록을 반환
		}
	}
	@Override
	public List<Goods> getGoodsByCategoryId(Long categoryId) {
		Optional<ProductCategory> categoryOptional = productCategoryRepository.findById(categoryId);
		if(categoryOptional.isPresent()) {
			ProductCategory productCategory = categoryOptional.get();
			return productRepository.findGoodsByProductCategory(productCategory);
		}else {
			return new ArrayList<>();  // 카테고리를 찾지 못한 경우 빈 목록을 반환
	}
}
	@Override
	public List<Ticket> getTicketByCategoryId(Long categoryId) {
		Optional<ProductCategory> categoryOptional = productCategoryRepository.findById(categoryId);
		if(categoryOptional.isPresent()) {
			ProductCategory productCategory = categoryOptional.get();
			return productRepository.findTicketByProductCategory(productCategory);
		}else {
			return new ArrayList<>();  // 카테고리를 찾지 못한 경우 빈 목록을 반환
	}
	}



}

