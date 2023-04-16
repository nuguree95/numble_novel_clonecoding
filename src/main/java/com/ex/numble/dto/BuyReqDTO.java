package com.ex.numble.dto;

import lombok.Data;

@Data
public class BuyReqDTO {
	
	// 차감 할 티켓 수
	private int ticket;
	
	// 에피소드 seq
	private int e_seq;
	
	// 소설 seq
	private int n_seq;
}
