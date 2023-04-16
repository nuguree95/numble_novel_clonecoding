package com.ex.numble.service;

import org.springframework.stereotype.Service;

import com.ex.numble.dto.TicketDTO;
import com.ex.numble.dto.TicketReqDTO;
import com.ex.numble.mapper.TicketMapper;
import com.ex.numble.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketService {

	private final TicketMapper ticketMapper;
	
	private final UserMapper userMapper;
	
	public TicketDTO addPoint(TicketReqDTO dto) {
		
		Boolean pass = false;
		TicketDTO rtnDto = new TicketDTO();
		
		// 3장 10%, 6장 15%, 9장 20%, 한번에 25% 할인해줌
		if(dto.getTicket() < 3) {
			if (dto.getTicket() * 100 == dto.getPoint())
				pass = true;
		} else if(dto.getTicket() >= 3 && dto.getTicket() < 6 ) {
			if (dto.getTicket() * 100 * 0.9 == dto.getPoint())
				pass = true;
		} else if(dto.getTicket() >= 6 && dto.getTicket() < 9 ) {
			if (dto.getTicket() * 100 * 0.85 == dto.getPoint())
				pass = true;
		} else if(dto.getTicket() == 9 ) {
			if (dto.getTicket() * 100 * 0.80 == dto.getPoint())
				pass = true;
		} else {
			if (dto.getTicket() * 100 * 0.75 == dto.getPoint())
				pass = true;
		}
		
		if(!pass) {
			rtnDto.setTicket(0);
			return rtnDto;
		}
		
		dto.setTicket(userMapper.selectUser().getTicket() + dto.getTicket());
		ticketMapper.addTicket(dto);
		
		// select
		rtnDto = ticketMapper.getTicket(dto.getU_seq());
		
		return rtnDto;
	}
}
