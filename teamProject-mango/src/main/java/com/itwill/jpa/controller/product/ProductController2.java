package com.itwill.jpa.controller.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.jpa.controller.user.LoginCheck;
import com.itwill.jpa.dto.product.ProductMusicDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.product.ProductRepository;
import com.itwill.jpa.service.product.ProductService;
import com.itwill.jpa.service.product.ProductServiceImpl;
import com.itwill.jpa.service.user.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductController2 {
	
	@Autowired
	private final ProductService productService;
	@Autowired
	private final UserService userService;
	
	// 뮤직리스트 
	@GetMapping("/music_list")
	public String musicList(Model model) {
		try {
			List<Product> musics = productService.findByCategoryId(1L);
			model.addAttribute("musics", musics);
			log.info(">>>MUSIC LIST : " + musics);
			return "music_list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return null;
		}
	}

	// 뮤직디테일
	@GetMapping("/music_detail/{productNo}")
	public String MusicDetail(@PathVariable Long productNo, Model model) {
		try {
			Product musicDetail = (Product) productService.findByProductNo(productNo).get();
			System.out.println(productNo);
			System.out.println(musicDetail);
			
			productService.increaseReadCount(musicDetail);
					//readCount increase 작업 성공
			model.addAttribute("musicDetail", musicDetail);
			log.info(">>>MUSIC DETAIL :"+  musicDetail);
					
					//https://m.blog.naver.com/yh_park02/221726954404
			return "music_detail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return null;
		}
	}
	
	// 멤버십
	@GetMapping("/membership_detail")
	public String MembershipDetail(HttpSession session,Model model) {
		try {
			List<Product> memberships = productService.findByCategoryId(4L);
			if(session.getAttribute("")!=null) {
				//user로 멤버십 구매 찾기?
				
				
			}else {
				model.addAttribute("memberships", memberships);
			}
			System.out.println(">>>MEMBERSHIP LIST : " + memberships);
			return "membership_detail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return null;
		}
	}

	// 굿즈리스트
		@GetMapping("/goods_list")
		public String GoodsList(Model model) {
			try {
				List<Product> goods = productService.findByCategoryId(2L);
				model.addAttribute("goods", goods);
				System.out.println(">>>GOODS LIST : " + goods);
				return "goods_list";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return null;
			}
		
		}
		
		// 티켓리스트
		@GetMapping("/ticket_list")
		public String TicketList(Model model) {
			try {
				List<Product> tickets = productService.findByCategoryId(3L);
				model.addAttribute("tickets", tickets);
				System.out.println(">>>TICKET LIST : " + tickets);
				return "ticket_list";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return null;
			}
			
		}
		
		// 티켓디테일
		@GetMapping("/ticket_detail/{productNo}")
		public String TicketDetail(Model model) {
			try {
				
				return "ticket_detail";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return null;
			}
			
		}
		
		// 굿즈디테일
		@GetMapping("/goods_detail/{productNo}")
		public String GoodsDetail(Model model) {
			try {
				
				return "goods_detail";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return null;
			}
			
		}
	
}
