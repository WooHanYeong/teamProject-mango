package com.itwill.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

	@GetMapping("/index") 
	public String index() { 
		String forward_path = "index"; 
		return forward_path; 
	}
	@GetMapping("/userprofile")
	public String userprofile() {
		String forwardPath = "userprofile";
		return forwardPath;
	}
	@GetMapping("/test") 
	public String test() { 
		String forward_path = "test"; 
		return forward_path; 
	}
	@GetMapping("/common") 
	public String common() { 
		String forward_path = "common"; 
		return forward_path; 
	}
	

	
}
