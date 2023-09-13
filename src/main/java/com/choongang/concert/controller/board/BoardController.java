package com.choongang.concert.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choongang.concert.dto.board.PageNoticeDto;
import com.choongang.concert.dto.board.PagingResponse;
import com.choongang.concert.entity.board.Notice;
import com.choongang.concert.service.board.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
// 요청을 board로 라우팅 
@RequestMapping("/board")
// 해당클래스의 필드에 대한 생성자가 자동으로 생성 중복코드를 작성을 피할 수 있다.
@RequiredArgsConstructor
public class BoardController {

	@Autowired
	private BoardService boardService;

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

	@GetMapping("/notice/list")
	public String openPostList(@ModelAttribute("params") final PageNoticeDto params, Model model) {
		PagingResponse<Notice> response = boardService.noticeBoard(params);
		model.addAttribute("response", response);
		return "board/notice_list";
	}
//	public String noticeList(@ModelAttribute("params") final PageNoticeDto params, Model model) {
////		List<Notice> noticeBoard = boardService.noticeBoard();
//		List<Notice> noticeFindByNumPost = boardService.noticeFindByNumPost(params);
//		model.addAttribute("noticeFindByNumPost", noticeFindByNumPost);
////		model.addAttribute("noticeBoard", noticeBoard);
////		/log.info("노티스 : " + noticeBoard);
//		return "board/notice_list";


	
	
//	@GetMapping("/qna/list")
//	public String qnaListBoard(Model model) {
//		List<QnaList> qnaListBoard = boardService.qnaListBoard();
//		model.addAttribute("qnaListBoard", qnaListBoard);
//		return "board/qna_list";
//	}

//	@GetMapping("/qna/list")
////	 @ModelAttribute QnaList qnaList :@ModelAttribute 어노테이션은 메서드의 파라미터로 사용되며,
////	 요청 파라미터를 QnaList 객체에 자동으로 바인딩합니다.
////	 즉, HTTP 요청의 파라미터를 QnaList 객체의 필드에 매핑합니다.
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
