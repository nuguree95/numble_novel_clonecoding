package com.ex.numble.batch;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ex.numble.dto.BestSellerDTO;
import com.ex.numble.mapper.NovelMapper;

import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class BestSellerPerDay {
	
	private final NovelMapper novelMapper;
	
	public static List<BestSellerDTO> bestSeller;
	
	@Scheduled( cron="*/5 * * * * *" )//5초마다
	public void BestSeller() {
		
		List<BestSellerDTO> bestSellerList = novelMapper.bestSeller();
		bestSeller = bestSellerList;
	}

}
