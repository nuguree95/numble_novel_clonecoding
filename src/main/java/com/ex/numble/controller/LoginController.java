package com.ex.numble.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.numble.dto.UserDTO;
import com.ex.numble.service.UserService;

@RestController
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("login")
	public ResponseEntity<?> Login(HttpServletRequest req) {
		
		UserDTO userDTO = userService.selectUser();		
		
		HttpSession session = req.getSession();
		session.setAttribute("userDTO", userDTO);
		
		return ResponseEntity.ok().body("로그인 성공");
	}

}
