package com.choongang.concert.entity.board;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeRequest {
	
	// Request 
	
	private Long id;					// PK 
	private String category;			// 카테고리
	private String title;				// 제목 
	private LocalDateTime createdAt;		// 게시글 만든 시간 
	private Long viewCnt;				// 조회수 
	
}
