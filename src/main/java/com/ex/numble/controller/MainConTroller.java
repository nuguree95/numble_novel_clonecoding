package com.ex.numble.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.numble.batch.BestSellerPerDay;
import com.ex.numble.dto.BestSellerDTO;

@RestController
@RequestMapping("")
public class MainConTroller {
	
	@Autowired
	BestSellerPerDay bestSellerBatch;
	
	@GetMapping("/best-seller")
	public List<BestSellerDTO> bestSeller(){
		
		return bestSellerBatch.bestSeller;
		
	}

}
