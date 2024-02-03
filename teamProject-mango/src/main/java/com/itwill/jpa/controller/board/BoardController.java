package com.itwill.jpa.controller.board;

import java.util.List;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.jpa.entity.board.Board;
import com.itwill.jpa.entity.board.BoardType;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.service.board.BoardServiceImpl;
import com.itwill.jpa.service.user.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class BoardController {

	private final BoardServiceImpl boardServiceImpl;
	
	private UserServiceImpl userServiceImpl;

	@GetMapping("/event")
	public String eventPage(Model model) {
		try {
			List<Board> events = boardServiceImpl.findBycategory(2L);
			model.addAttribute("events", events);
			System.out.println("이벤트 리스트 :" + events);
			return "event"; // 뷰 템플릿의 경로를 "event"로 설정
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG : " + e.getMessage());
			return null;
		}
	}

	@GetMapping("/notification")
	public String notificationPage(Model model) {
		try {
			List<Board> notifications = boardServiceImpl.findBycategory(1L);
			model.addAttribute("notifications", notifications);
			System.out.println("notifications리스트 : " + notifications);
			
			List<BoardType> boardTypes =boardServiceImpl.findAllByOrderByTypeIdAsc();
			System.out.println("boardTypeList" + boardTypes);
			model.addAttribute("boardTypes",boardTypes);
			
			return "notification";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG : " + e.getMessage());
			return null;
		}
	}

	@GetMapping("/magazine")
	public String magazine(Model model) {
		try {
			List<Board> magazines = boardServiceImpl.findBycategory(3L);
			model.addAttribute("magazines", magazines);
			System.out.println("magazine 리스트 : " + magazines);
			return "magazine";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG : " + e.getMessage());
			return null;
		}
	}

	@GetMapping("/inquiries")
	public String inquiries(Model model) {
		try {
			List<Board> inquiries 
				= boardServiceImpl.findByBoardCategory_IdAndUser_UserIdOrderByCreatedTime(4L,"why3795");
			model.addAttribute("inquiries", inquiries);
			System.out.println("inquiries 리스트 : " + inquiries);
			
			return "inquiries";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG : " + e.getMessage());
			return null;
		}
	}

	
	
	@GetMapping("/faq")
	public String faq(Model model) {
		try {
			List<Board> faqs = boardServiceImpl.findBycategory(5L);
			model.addAttribute("faqs", faqs);
			System.out.println("FAQ 리스트 :" + faqs);
			List<BoardType> boardTypes =boardServiceImpl.findAllByOrderByTypeIdAsc();
			System.out.println("boardTypeList" + boardTypes);
			model.addAttribute("boardTypes",boardTypes);
			return "faq"; // 뷰 템플릿의 경로를 "faq"로 설정
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG : " + e.getMessage());
			return null;
		}
	}
}
