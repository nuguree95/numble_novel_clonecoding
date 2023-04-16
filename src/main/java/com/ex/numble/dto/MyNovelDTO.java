package com.ex.numble.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MyNovelDTO {
	
	private String title;
	
	//마지막으로 읽은날
	private Date read_date;
	
	//마지막으로 읽은 소설
	private int recent_episode;
	
	//소설의 마지막화
	private int last_episode;

}
