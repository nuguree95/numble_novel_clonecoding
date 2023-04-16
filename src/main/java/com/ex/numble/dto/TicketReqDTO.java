package com.ex.numble.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class TicketReqDTO {
	
	@JsonIgnore
	private int u_seq;
	
	private int ticket;
	
	private int point;
	

}
