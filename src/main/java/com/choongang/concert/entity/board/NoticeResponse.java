package com.choongang.concert.entity.board;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class NoticeResponse {

	private Long id;		// PK
	private Long adminId;	// 어드민id 
	private String title;   // 제목 
	private String writer;  // 작성자
	private String content; // 내용 
	private int viewCnt;   // 조회 수
	private LocalDateTime createdAt; // 생성일시
	private LocalDateTime updatedAt; // 업데이트 일시
	private Boolean deleteYn;        // 삭제 여부 
	private String fileName; 		 // 파일 명 
	private String filePath; 		 // 파일 경로 
	private String category;		 // 카테고리 
}
