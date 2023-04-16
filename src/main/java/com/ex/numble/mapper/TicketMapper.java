package com.ex.numble.mapper;


import com.ex.numble.dto.TicketDTO;
import com.ex.numble.dto.TicketReqDTO;

public interface TicketMapper {
	
	void addTicket(TicketReqDTO dto);

		
	TicketDTO getTicket(int u_seq);

}
