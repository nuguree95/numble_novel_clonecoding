package com.ex.numble.mapper;

import java.util.List;

import com.ex.numble.dto.BestSellerDTO;
import com.ex.numble.dto.EpisodeDTO;
import com.ex.numble.dto.MyNovelDTO;
import com.ex.numble.dto.NovelDTO;

public interface NovelMapper {
	
	public List<MyNovelDTO> selectMyNovel();
	
	public void addNovel(NovelDTO dto);
	
	void deleteNovel(int seq);
	
	List<EpisodeDTO> readEpisode(int seq);
	
	List<BestSellerDTO> bestSeller();

}
