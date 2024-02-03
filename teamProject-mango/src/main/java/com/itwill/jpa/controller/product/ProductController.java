package com.itwill.jpa.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.jpa.repository.product.ProductRepository;
import com.itwill.jpa.service.product.ProductService;
import com.itwill.jpa.service.product.ProductServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

	@Autowired
	private final ProductServiceImpl productServiceImpl;
/*
	// 굿즈리스트
	@GetMapping("/GoodsList")
	public String GoodsList(Model model) {
		log.info("GoodsList");
		return "GoodsList";
	}
	
	// 티켓리스트
	@GetMapping("/TicketList")
	public String TicketList() {
		log.info("TicketList");
		return "TicketList";
	}
	
	// 티켓디테일
	@GetMapping("/TicketDetail")
	public String TicketDetail() {
		log.info("TicketDetail");
		return "TicketDetail";
	}
	
	// 굿즈디테일
	@GetMapping("/GoodsDetail")
	public String GoodsDetail() {
		log.info("GoodsDetail");
		return "GoodsDetail";
	}
	
*/
	
	
}
