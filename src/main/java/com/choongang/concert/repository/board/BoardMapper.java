package com.choongang.concert.repository.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.concert.dto.board.PageNoticeDto;
import com.choongang.concert.entity.board.Notice;

@Mapper
public interface BoardMapper {
	
//	// notice_board 
//	List<Notice> noticeBoardFindAll();

	
	// 게시글 리스트 조회 @return 게시글 리스트 
	List<Notice> noticeFindAll(PageNoticeDto params);
	
	// 게시글 수 카운팅 return 게시글 수 
	int noticeFindByNumCnt(PageNoticeDto params);
	
	

//--------------------------------------------------------------------------------------------
	
	

	// Qna_board
//	List<QnaList> qnaBoardFindAll();
	
//	List<QnaList> qnaBoardFindAll(Long qnaListNum);
//	
//	int qnaListFindAllCnt(QnaList qnaList);
	
	
	// event_list 
//	List<EventList> eventBoardFindAll();
	
//	EventList eventBoardFindAll(Long eventListNum);
//	
//	int eventFindAllCnt(EventList eventList);
}
