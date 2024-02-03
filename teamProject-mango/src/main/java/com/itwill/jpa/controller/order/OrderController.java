package com.itwill.jpa.controller.order;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.context.Context;

import com.itwill.jpa.dto.order.OrderDto;
import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.service.order.OrderItemService;
import com.itwill.jpa.service.order.OrderService;
import com.itwill.jpa.service.product.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private ProductService productService;

	//오더페이지를 일단 두개로 나눔 멤버쉽결제페이지 와 티켓결제페이지
	@GetMapping("/order_membership")
	public String orderMembershipPage(Model model, HttpServletRequest request) {
		
		try {
			HttpSession session = request.getSession();
			//일단 임의로 세션 로그인 유저 설정함
			session.setAttribute("user_id", "lsg33");
			String userId = (String) session.getAttribute("user_id");
			
			//로그인한 유저가 맞다면 오더페이지 아니면 로그인 페이지로 이동
			//로그인 체크가 생기면 아래 조건문 지울것
			if(userId != null) {
				//orderdetail.html에 리스트명 orderItemDtoList로 바꿈
				List<OrderItemDto> orderItemDtoList = orderItemService.orderItemsByUserId(userId);
				model.addAttribute("orderItemDtoList", orderItemDtoList);
				System.out.println("주문 아이템: " + orderItemDtoList);
				//이부분 위아래중 어떤 불러오기 서비스를 선택할지 논의가 필요
				//List<OrderDto> orderDtoList = orderService.ordersByUserId(userId);
				//model.addAttribute("orderDtoList", orderDtoList);
				//System.out.println("주문 아이템: " + orderDtoList);
				 // Product 엔티티의 정보를 저장할 변수
	            Date membershipStartPeriod = null;
	            String membershipName = null;
	            String membershipImage = null;
	            String membershipContent = null;
	            // 주문 아이템별로 Product 정보 가져오기
	            for (OrderItemDto orderItemDto : orderItemDtoList) {
	                Long productNo = orderItemDto.getProductNo();
	                Product product = productService.getProduct(productNo);

	                if (product != null) {
	                    // Product 엔티티의 멤버십 시작일 정보 가져오기
	                    membershipStartPeriod = product.getStartPeriod();
	                    membershipName = product.getProductName();
	                    membershipImage = product.getProductImage();
	                    membershipContent = product.getProductContent();
	                }
	            }
	            model.addAttribute("user_id", userId);
				model.addAttribute("orderItemDtoList", orderItemDtoList);
				model.addAttribute("membershipStartPeriod", membershipStartPeriod);
				model.addAttribute("membershipName", membershipName);
				model.addAttribute("membershipImage", membershipImage);
				model.addAttribute("membershipContent", membershipContent);
				System.out.println("커밋용");
				return "order_membership";
			} else {
				
				return "index";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("주문이 존재하지 않습니다.", e.getMessage());
			return "index";
		}
	}


	
	
	//오더페이지를 일단 두개로 나눔 멤버쉽결제페이지 와 티켓결제페이지
	@GetMapping("/order_ticket")
	public String orderTicketPage(Model model, HttpServletRequest request) {
		
		try {
			HttpSession session = request.getSession();
			//일단 임의로 세션 로그인 유저 설정함
			session.setAttribute("user_id", "wsm55");
			String userId = (String) session.getAttribute("user_id");
			
			//로그인한 유저가 맞다면 오더페이지 아니면 로그인 페이지로 이동
			//로그인 체크가 생기면 아래 조건문 지울것
			if(userId != null) {
				//orderdetail.html에 리스트명 orderItemDtoList로 바꿈
				List<OrderItemDto> orderItemDtoList = orderItemService.orderItemsByUserId(userId);
				model.addAttribute("orderItemDtoList", orderItemDtoList);
				System.out.println("주문 아이템: " + orderItemDtoList);
				//이부분 위아래중 어떤 불러오기 서비스를 선택할지 논의가 필요
				//List<OrderDto> orderDtoList = orderService.ordersByUserId(userId);
				//model.addAttribute("orderDtoList", orderDtoList);
				//System.out.println("주문 아이템: " + orderDtoList);
				
				// Thymeleaf 컨텍스트에 user_id와 orderItemDtoList를 추가(유저님의 100개의 주문입니다.)
	            Context context = new Context();
	            context.setVariable("user_id", userId);
	            context.setVariable("orderItemDtoList", orderItemDtoList);

	            // Thymeleaf 템플릿에 컨텍스트를 전달
	            model.addAttribute("context", context);
	            
				return "order_ticket";
			} else {
				//추후에 메인(index)페이지 대신에 로그인 페이지로 보낼예정
				return "index";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("주문이 존재하지 않습니다.", e.getMessage());
			return "index";
		}
	}

	
	
	//오더디테일에서 오더히스토리로 명명만 바꿈
	@GetMapping("/order_history")
	public String orderHistoryPage(Model model, HttpServletRequest request) {
		try {
			
			HttpSession session = request.getSession();
			//일단 임의로 세션 로그인 유저 설정함
			session.setAttribute("user_id", "wsm55");
			String userId = (String) session.getAttribute("user_id");
			
//			//테스트용 코드
//			List<OrderDto> testOrderDtoList = orderService.orders();
//			model.addAttribute("orderDtoNewerList", testOrderDtoList);
//			System.out.println("주문 내역 최신순:" + testOrderDtoList);
			
			//원래 코드
			//orderdetail.html에 리스트명 orderDtoNewerList로 바꿈
			List<OrderDto> orderDtoNewerList = orderService.orderListByNewer(userId);
			model.addAttribute("orderDtoNewerList", orderDtoNewerList);
			System.out.println("주문 내역 최신순:" + orderDtoNewerList);
			return "order_history";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("주문 내역이 없습니다.", e.getMessage());
			return "index";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
			
			
			
			

	
			
			
				
	
	
