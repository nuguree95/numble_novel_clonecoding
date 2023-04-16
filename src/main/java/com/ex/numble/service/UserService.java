package com.ex.numble.service;

import org.springframework.stereotype.Service;

import com.ex.numble.dto.UserDTO;
import com.ex.numble.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserMapper userMapper;
	
	public UserDTO selectUser() {
		
		return userMapper.selectUser();
	}
	
	public int getMyTicket(int u_seq) {
		return userMapper.getMyTicket(u_seq);
	}

	public void useTicket(int u_seq, int myTicket, int buyTicket) {
		
		// 남은 티켓 수 = 내 티켓 수 - 구매할 에피소드의 티켓 수
		int remainTicket = myTicket - buyTicket;
		
		userMapper.useTicket(u_seq, remainTicket);
	}
		
}
