package com.ex.numble.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ex.numble.dto.EpisodeDTO;
import com.ex.numble.dto.MyNovelDTO;
import com.ex.numble.dto.NovelDTO;
import com.ex.numble.mapper.NovelMapper;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class NovelService {
	
	private final NovelMapper novelMapper;
	
	public List<MyNovelDTO> selectMyNovel() {
		
		return novelMapper.selectMyNovel();
	}
	
	public void addNovel(NovelDTO dto) {
		
		novelMapper.addNovel(dto);
	}

	
	public void deleteNovel(int seq) {
		novelMapper.deleteNovel(seq);
	}
		
	public List<EpisodeDTO> readEpisode(int seq){
		
		return novelMapper.readEpisode(seq);
	}
}
