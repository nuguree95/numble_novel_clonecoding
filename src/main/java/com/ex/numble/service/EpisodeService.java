package com.ex.numble.service;

import org.springframework.stereotype.Service;

import com.ex.numble.mapper.EpisodeMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EpisodeService {
	
	private final EpisodeMapper episodeMapper;
	
	public void addMyNovel(int u_seq, int n_seq, int e_seq) {
		episodeMapper.addMyNovel(u_seq, n_seq, e_seq);
		// mapper update문3
	}
	
	

}
