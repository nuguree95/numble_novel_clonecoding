package com.ex.numble.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.numble.dto.BuyReqDTO;
import com.ex.numble.dto.EpisodeDTO;
import com.ex.numble.dto.UserDTO;
import com.ex.numble.service.EpisodeService;
import com.ex.numble.service.NovelService;
import com.ex.numble.service.UserService;

@RestController
@RequestMapping("/episode")
public class EpisodeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	EpisodeService epiService;
	
	@Autowired
	NovelService novelService;
	
	@PostMapping("/buy")
	public ResponseEntity<String> buyEpisode(@RequestBody BuyReqDTO reqDto, HttpServletRequest req){

		// 세션에 담긴 유저seq 가져오기
		HttpSession session = req.getSession();
		int u_seq = ((UserDTO) session.getAttribute("userDTO")).getUser_seq();
		
		// 내 티켓 수
		int myTicket = userService.getMyTicket(u_seq);
		
		// 내 티켓 차감
		userService.useTicket(u_seq, myTicket, reqDto.getTicket());
		
		// 구매목록에 에피소드 추가
		epiService.addMyNovel(u_seq, reqDto.getN_seq(), reqDto.getE_seq());
		
		return ResponseEntity.ok().body("구매성공");
	}
	
	@GetMapping("/episode/{seq}")
	public List<EpisodeDTO> readEpisode(@PathVariable int seq){
		
		return novelService.readEpisode(seq);
		
	}

}
