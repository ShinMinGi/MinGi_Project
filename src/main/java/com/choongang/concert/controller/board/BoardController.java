package com.choongang.concert.controller.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.choongang.concert.entity.board.NoticeRequest;
import com.choongang.concert.entity.board.NoticeResponse;
import com.choongang.concert.service.board.BoardService;

import lombok.RequiredArgsConstructor;


@Controller 
@RequiredArgsConstructor
public class BoardController {
	
	
	private final BoardService boardService;
	
	
	// 게시글 작성 페이지 
	@GetMapping("/notice/list")
	public String noticePostWrite(Model model) {
		List<NoticeRequest> noti = boardService.findAll();
		model.addAttribute("noti", noti);
		return "/board/notice_list";
	}
	
	@GetMapping("/board/notice/{id}")
	public String noticeDetail(@PathVariable Long id, Model model) { 
		NoticeResponse notice = boardService.findPostById(id);
		model.addAttribute("notice", notice);
		return "/board/basic_detail";
	}
	
	
	@GetMapping("/admin/write")
	public String adminWrite() {
		return "board/admin_write";
	}

	@GetMapping("/basic/detail")
	public String basicDetail() {
		return "board/basic_detail";
	}

	@GetMapping("/event/card")
	public String eventCard() {
		return "board/event_card";
	}

	@GetMapping("/event/detail")
	public String eventDetail() {
		return "board/event_detail";
	}

	/*
	 * @GetMapping("/event/list") public String eventList(Model model) {
	 * List<EventList> eventBoard = boardService.eventBoard();
	 * model.addAttribute("eventBoard", eventBoard); return "board/event_list"; }
	 */



//	@GetMapping("/notice/list")
//	public String noticeList(Model model) {
//		List<Notice> noticeBoard = boardService.noticeBoard();
//		model.addAttribute("noticeBoard", noticeBoard);
//		return "board/notice_list";
//	}



	
	
//	@GetMapping("/qna/list")
//	public String qnaListBoard(Model model) {
//		List<QnaList> qnaListBoard = boardService.qnaListBoard();
//		model.addAttribute("qnaListBoard", qnaListBoard);
//		return "board/qna_list";
//	}
//
//	@GetMapping("/qna/list")
//	 @ModelAttribute QnaList qnaList :@ModelAttribute 어노테이션은 메서드의 파라미터로 사용되며,
//	 요청 파라미터를 QnaList 객체에 자동으로 바인딩합니다.
//	 즉, HTTP 요청의 파라미터를 QnaList 객체의 필드에 매핑합니다.
//	public String qnaList(@ModelAttribute QnaList qnaList, @RequestParam(value = "page", defaultValue = "1") int page, Model model) {
//		
//		int count = boardService.findByQnaListCount(qnaList);
//		PageQnaListDto pageQnaListDto = new PageQnaListDto(count, page);
//		List<QnaList> qnaListList = boardService.findQnaList(pageQnaListDto);
//		
//		log.info("QnaList = {}", qnaListList.get(0));
//		log.info("qnaList count = {}", count);
//		
//		model.addAttribute("qnaListList", qnaListList);
//		model.addAttribute("page",page);
//		model.addAttribute("pageDto", pageQnaListDto);
//		model.addAttribute("count",count);
//		
//		return "board/qna_list";
//	}

	@GetMapping("/user/write?{id}")
	public String userwrite() {
		return "/board/user_write";
	}
}
