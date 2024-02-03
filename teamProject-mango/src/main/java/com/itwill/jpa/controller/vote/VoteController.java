package com.itwill.jpa.controller.vote;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.jpa.service.board.BoardServiceImpl;

import lombok.RequiredArgsConstructor;
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class VoteController {

	@GetMapping(value = "/voteMain")
	public String vote_html() {
		return "voteMain";
	}


}
