
package com.itwill.jpa.controller.user;

import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.dto.user.UserLoginDto;
import com.itwill.jpa.dto.user.UserUpdateDto;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.service.user.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user_view")
	public String user_view() {
		String forward_path = "user_view";
		return forward_path;
	}
	
	@GetMapping("/user_modify_form")
	public String user_modify_form() {
		String forward_path = "user_modify_form";
		return forward_path;
	}
	
	@GetMapping("/user_cart")
	public String user_cart() {
		String forward_path = "user_cart";
		return forward_path;
	}

	@GetMapping("/user_write_form")
	public String user_write_form() {
		String forward_path = "user_write_form";
		return forward_path;
	}

	@PostMapping("/user_write_action")
	public String user_write_action(@ModelAttribute("fuser") UserDto userDto, Model model) throws Exception {
		String forward_path = "";
		try {
			UserDto createUser = userService.createUser(userDto);
			forward_path = "redirect:user_login_form";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			model.addAttribute("fuser", userDto);
			forward_path = "user_write_form";
		}
		return forward_path;
	}

	@GetMapping("/user_login_form")
	public String user_login_form() {
		String forward_path = "user_login_form";
		return forward_path;
	}

	@PostMapping("/user_login_action")
	public String user_login_action(@ModelAttribute("fuser") UserLoginDto userLoginDto, Model model, HttpSession session)
			throws Exception {
		String forwardPath = "";
		try {
			userService.loginUser(userLoginDto.getUserId(), userLoginDto.getUserPw());
			session.setAttribute("sUserId", userLoginDto.getUserId());
			forwardPath = "redirect:index";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg1", e.getMessage());
			forwardPath = "user_login_form";
		}
		return forwardPath;
	}

	@GetMapping("/userCheckIdPw")
	public String userCheckIdPw() {
		String forward_path = "userCheckIdPw";
		return forward_path;
	}
	/*
	@RequestMapping("/user_view")
	public String user_view(HttpServletRequest request, Model model) throws Exception {
		String forwardPath = "";
		
		String sUserId = (String) request.getSession().getAttribute("sUserId");
		User loginUser = userService.findUser(sUserId);
		model.addAttribute("loginUser", loginUser);
		forwardPath = "user_view";

		return forwardPath;
	}
	*/
	/*
	@GetMapping("/user_modify_form")
	public String user_modify_form(HttpServletRequest request, Model model) throws Exception {
		String forwardPath = "";

		String sUserId = (String) request.getSession().getAttribute("sUserId");
		User loginUser = userService.findUser(sUserId);
		model.addAttribute("loginUser", UserUpdateDto.toDto(loginUser));
		forwardPath = "user_modify_form";

		return forwardPath;
	}
	*/

	@PostMapping("user_modify_action")
	public String user_modify_action(@ModelAttribute UserUpdateDto userUpdateDto, HttpServletRequest request) throws Exception {
		String forwardPath = "";
		
		String sUserId = (String) request.getSession().getAttribute("sUserId");
		userService.updateUser(userUpdateDto);
		forwardPath = "redirect:user_view";
		return forwardPath;
	}

	@PostMapping("user_remove_action")
	public String user_remove_action(HttpServletRequest request) throws Exception {
		String forwardPath = "";

		String sUserId = (String) request.getSession().getAttribute("sUserId");
		userService.deleteUser(sUserId);
		request.getSession().invalidate();
		forwardPath = "redirect:index";
		return forwardPath;
	}

	@RequestMapping("user_logout_action")
	public String user_logout_action(HttpServletRequest request) {
		String forwardPath = "";

		request.getSession(false).invalidate();
		forwardPath = "redirect:index";

		return forwardPath;
	}

	/*********** GET방식요청시 guest_main redirection *********/
	@GetMapping({ "user_write_action", "user_login_action", "user_modify_action",
			"user_remove_action" })
	public String user_get() {
		String forwardPath = "redirect:index";
		return forwardPath;
	}

}