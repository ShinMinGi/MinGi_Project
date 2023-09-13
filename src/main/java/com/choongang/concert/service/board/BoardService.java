package com.choongang.concert.service.board;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choongang.concert.dto.board.PageNoticeDto;
import com.choongang.concert.dto.board.Pagination;
import com.choongang.concert.dto.board.PagingResponse;
import com.choongang.concert.entity.board.Notice;
import com.choongang.concert.repository.board.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
// 클래스 필드 기반 자동 생성 
@RequiredArgsConstructor
public class BoardService {


	@Autowired
	private final BoardMapper boardMapper;
	
	
	// notice_Board 게시판
//	public List<Notice> noticeBoard() {
//		return boardMapper.noticeBoardFindAll();
//	}
	
	// notice 게시글 리스트 조회
	public PagingResponse<Notice> noticeBoard(final PageNoticeDto params) {
		
		// 조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와 null을 담아 반환 
		int noticeFindByNumCnt = boardMapper.noticeFindByNumCnt(params);
		System.out.println("1 : " + noticeFindByNumCnt);
		if (noticeFindByNumCnt < 1) {
			return new PagingResponse<>(Collections.emptyList(), null);
		}
		
		// Pagination 객체를 생성해서 페이지 정보 계산 후 PageNoticeDto 타입의 객체인 params에 계산된 페이지 정보 저장 
		Pagination pagination = new Pagination(noticeFindByNumCnt, params);
		params.setPagination(pagination);
		
		// 계산된 페이지 정보의 일부(limitStart, recordSize) 를 기준으로 리스트 데이터 조회 후 응답 데이터 반환 
		List<Notice> list = boardMapper.noticeFindAll(params);
		return new PagingResponse<>(list, pagination);
	}
	
	


	
//--------------------------------------------------------------------------------------------------------------------
	
	
	
	// Qna_Board 게시판 
//	public List<QnaList> qnaListBoard(){
//		return boardMapper.qnaBoardFindAll();
//	}


//--------------------------------------------------------------------------------------------------------------------

	
	
	// Event_Board 게시판 
//	public List<EventList> eventBoard() {
//		return boardMapper.eventBoardFindAll();
//	}

}