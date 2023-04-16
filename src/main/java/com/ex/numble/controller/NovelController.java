package com.ex.numble.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.numble.dto.MyNovelDTO;
import com.ex.numble.dto.NovelDTO;
import com.ex.numble.service.NovelService;

@RestController
@RequestMapping("/novels")
public class NovelController {
	
	@Autowired
	NovelService novelService;
	
	
	@GetMapping("/my")
	public ResponseEntity<List<MyNovelDTO>> selectMyNovel(){
		
		List<MyNovelDTO> myNovel = new ArrayList<MyNovelDTO>();
		
		myNovel = novelService.selectMyNovel();
		
		return ResponseEntity.ok().body(myNovel);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addNovel(@RequestBody NovelDTO dto,HttpServletRequest req){
		novelService.addNovel(dto);
		return ResponseEntity.ok().body("등록성공");
		
	}
	
	@DeleteMapping("/delete/{seq}")
	public ResponseEntity<String> deleteNovel(@PathVariable int seq){
		
		novelService.deleteNovel(seq);
		return ResponseEntity.ok().body("삭제성공");
	}
	

}
