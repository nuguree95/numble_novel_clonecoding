package com.ex.numble.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.numble.dto.TicketDTO;
import com.ex.numble.dto.TicketReqDTO;
import com.ex.numble.dto.UserDTO;
import com.ex.numble.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@PostMapping("")
	public ResponseEntity<?> addTicket(@RequestBody TicketReqDTO dto, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
		
		dto.setU_seq(userDTO.getUser_seq());
		
		TicketDTO ticketDto = ticketService.addPoint(dto);
		
		if(ticketDto.getTicket() == 0)
			return ResponseEntity.badRequest().body("충전 실패");
		
		return ResponseEntity.ok().body(ticketDto);
	}

}
