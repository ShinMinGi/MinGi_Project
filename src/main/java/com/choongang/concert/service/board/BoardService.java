package com.choongang.concert.service.board;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choongang.concert.entity.board.NoticeRequest;
import com.choongang.concert.entity.board.NoticeResponse;
import com.choongang.concert.repository.board.BoardMapper;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class BoardService {
	
	
	private final BoardMapper boardMapper;
	
	
	/**
	 * 게시글 저장 
	 * @param params - 게시글 정보 	  		save 게시글을 생성하는 INSERT 쿼리를 호출한다. 
	 * 							  		파라미터로 전달받는 PARAMS는 요청 클래스 객체이며 params에는 저장할 게시글 정보가 담긴다 
	 */
	@Transactional
	public Long savePost(final NoticeRequest params) {
		boardMapper.save(params);
		return params.getId();
	}
	
	/*
	 * 게시글 상세정보 조회 
	 * @param id - PK 					findByid 특정 게시글을 조회하는 SELECT 쿼리를 호출한다 
	 * @return 게시글 상세정보 				쿼리가 실행되면 메서드의 리턴 타입인 응답(PostResponse) 클래스 객체의 각 멤버 변수에 결과값이 매핑(바인딩)됩니다.
	 */
	
	public NoticeResponse findPostById(final Long id) {
		return boardMapper.findById(id);
	}
	
	/*
	 * 게시글 수정  
	 * @param params - 게시글 정보 			게시글 정보를 수정하는 UPDATE 쿼리를 호출합니다. save( )와 마찬가지로 요청(PostRequest) 클래스의 객체를 파라미터로 전달받으며,
	 * 									params에는 수정할 게시글 정보가 담기게 됩니다.
	 */
	@Transactional 
	public Long updatePost(final NoticeRequest params) {
		boardMapper.update(params);
		return params.getId();
	}
	
	/*
	 * 게시글 삭제 							게시글을 삭제 처리하는 UPDATE 쿼리를 호출합니다. findById() 와 마찬가지로 id(PK)를 파라미터로 전달받아 
	 * @param id - PK 					SQL 쿼리의 WHERE 조건으로 사용하게 되며, SQL 쿼리가 실행되면 삭제 여부(delete_yn) 칼럼의 상태 값을 
	 * 									0에서 1로 업데이트 한다. 실무에서는 데이터가 DELETE(물리적인 삭제) 되어버리면 리스크가 크기 때문에 논리적인
	 * 									삭제 방식을 이용한다
	 */
	
	public Long deletePost(final Long id) {
		boardMapper.deleteById(id);
		return id;
	}
	
	
	public List<NoticeRequest> findAll() {
		return boardMapper.findAll();
	}
	
	
	// 조회수 업그레이드 
	public NoticeResponse findViewPostById(Long id) {
		// 게시물 조회 
		NoticeResponse nt = boardMapper.findById(id); 
		
		// 조회수 증가 
		boardMapper.updateViewCnt(id);
		
		return nt;
		
	}

	
//--------------------------------------------------------------------------------------------------------------------
	
	
	
// 		Qna_Board 게시판 
//	public List<QnaList> qnaListBoard(){
//		return boardMapper.qnaBoardFindAll();
//	}


//--------------------------------------------------------------------------------------------------------------------

	
	
	// Event_Board 게시판 
//	public List<EventList> eventBoard() {
//		return boardMapper.eventBoardFindAll();
//	}

}