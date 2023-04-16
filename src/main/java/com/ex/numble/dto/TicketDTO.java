package com.ex.numble.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class TicketDTO {
	
	@JsonIgnore
	private int u_seq;
	
	private int ticket;

}
