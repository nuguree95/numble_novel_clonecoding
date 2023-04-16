package com.ex.numble.mapper;

import org.apache.ibatis.annotations.Select;

import com.ex.numble.dto.UserDTO;

public interface UserMapper {

	@Select("select u.seq as user_seq, p.ticket from users u , point p  where u.seq = 1 and p.u_seq = u.seq")
	public UserDTO selectUser();
	
	int getMyTicket(int u_seq);

	void useTicket(int u_seq, int remainTicket);
	
}
