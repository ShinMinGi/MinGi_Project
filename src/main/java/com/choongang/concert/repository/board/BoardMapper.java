package com.choongang.concert.repository.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.concert.entity.board.NoticeRequest;
import com.choongang.concert.entity.board.NoticeResponse;




@Mapper
public interface BoardMapper {
	
	/**
	 * 게시글 저장 
	 * @param params - 게시글 정보 	  		save 게시글을 생성하는 INSERT 쿼리를 호출한다. 
	 * 							  		파라미터로 전달받는 PARAMS는 요청 클래스 객체이며 params에는 저장할 게시글 정보가 담긴다 
	 */
	void save(NoticeRequest params);
	
	/*
	 * 게시글 상세정보 조회 
	 * @param id - PK 					findByid 특정 게시글을 조회하는 SELECT 쿼리를 호출한다 
	 * @return 게시글 상세정보 				쿼리가 실행되면 메서드의 리턴 타입인 응답(PostResponse) 클래스 객체의 각 멤버 변수에 결과값이 매핑(바인딩)됩니다.
	 */
	NoticeResponse findById(Long id);
	
	/*
	 * 게시글 수정  
	 * @param params - 게시글 정보 			게시글 정보를 수정하는 UPDATE 쿼리를 호출합니다. save( )와 마찬가지로 요청(PostRequest) 클래스의 객체를 파라미터로 전달받으며,
	 * 									params에는 수정할 게시글 정보가 담기게 됩니다.
	 */
	void update(NoticeRequest params);
	
	/*
	 * 게시글 삭제 							게시글을 삭제 처리하는 UPDATE 쿼리를 호출합니다. findById() 와 마찬가지로 id(PK)를 파라미터로 전달받아 
	 * @param id - PK 					SQL 쿼리의 WHERE 조건으로 사용하게 되며, SQL 쿼리가 실행되면 삭제 여부(delete_yn) 칼럼의 상태 값을 
	 * 									0에서 1로 업데이트 한다. 실무에서는 데이터가 DELETE(물리적인 삭제) 되어버리면 리스크가 크기 때문에 논리적인
	 * 									삭제 방식을 이용한다
	 */
	void deleteById(Long id);
	
	/*
	 * 게시글 리스트 조회
	 * @return 게시글 리스트  
	 */
	List<NoticeRequest> findAll();
	
	
	

	


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
