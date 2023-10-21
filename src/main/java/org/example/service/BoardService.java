package org.example.service;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.board.ArticleDto;
import org.example.entity.BoardArticle;
import org.example.repository.BoardArticleRepository;
import org.example.repository.BoardInfoRepository;
import org.example.repository.BoardPagingRepository;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author 임승범
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardInfoRepository boardInfoRepository;
    private final BoardArticleRepository boardRepository;
    private final BoardPagingRepository boardPagingRepository;

    // jpa 페이징 리스트 가져오기(게시글 목록)
    public Page<BoardArticle> getArticlesByBoardId(Long boardId , Pageable pageable){

        return boardPagingRepository.findByBoardInfo_IdAndIsDeletedFalse(boardId , pageable);
    }

    // 게시글 하나 id로 가져오기(상세조회)
    public BoardArticle findById(Long id){
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found : BoardArticle의 " + id + "를 찾을 수 없음."));
    }

    // 새로운 게시글 추가하기(게시글 추가)
    public BoardArticle save(ArticleDto articleDto){

//        log.info("articleDto::{}" , articleDto);
        BoardArticle article = articleDto.toEntity();

        return boardRepository.save(article);
    }

    // 게시글 하나 id로 수정하기(게시글 수정)
    @Transactional
    public BoardArticle update(Long id , ArticleDto articleDto){

        BoardArticle article = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found : BoardArticle의 " + id + "를 찾을 수 없음."));

        log.info("업데이트 하려는 articleDto::{}",articleDto);
        article.update(articleDto);

        return article;

    }

    // 게시글 하나 논리삭제(isDeleted = true 변경)
    @Transactional
    public BoardArticle delete(Long id){
        BoardArticle article = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found : BoardArticle의 " + id + "를 찾을 수 없음."));
        article.delete();

        return article;
    }

    // 게시글 리스트 제목 검색
    public Page<BoardArticle> searchByTitle(String searchValue , Long boardInfoId , Pageable pageable){
        Page<BoardArticle> articles = boardPagingRepository.searchByArticleTitle(searchValue , boardInfoId, pageable);
        return articles;
    }

    // 게시글 리스트 내용 검색
    public Page<BoardArticle> searchByContent(String searchValue , Long boardInfoId, Pageable pageable){
        Page<BoardArticle> articles = boardPagingRepository.searchByArticleContent(searchValue , boardInfoId, pageable);
        return articles;
    }

    // 게시글 리스트 작성자 검색
    public Page<BoardArticle> searchByWriter(String searchValue , Long boardInfoId, Pageable pageable){
        Page<BoardArticle> articles = boardPagingRepository.searchByMemberId_UserName(searchValue , boardInfoId, pageable);
        return articles;
    }

    // 이전 게시글 가져오기
    public BoardArticle findBeforeBoardArticle(Long nowId , Long boardId , Pageable pageable){
        Page<BoardArticle> page = boardRepository.findBeforeBoardArticle(nowId , boardId , pageable);
        List<BoardArticle> articles = page.getContent();
        if(articles.isEmpty()){
            BoardArticle article = null;
            return null;
        }
        return articles.get(0);
    }

    // 다음 게시글 가져오기
    public BoardArticle findNextBoardArticle(Long nowId , Long boardId , Pageable pageable){
        Page<BoardArticle> page = boardRepository.findNextBoardArticle(nowId, boardId, pageable);
        List<BoardArticle> articles = page.getContent();
        if (articles.isEmpty()) {
            BoardArticle article = null;
            return article;
        }
        return articles.get(0);
    }

    // 조회수 증가 , 중복방지
    public BoardArticle updateView(Long id , HttpSession httpSession){
        // 게시글 가져오면서 안되면 예외 던지기.
        BoardArticle article = boardRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Not found : " + id + "로 entity 찾기 불가."));

        // 세션에서 지금까지 본 게시글 리스트 가져오기
        Object sessionItem = httpSession.getAttribute("viewedArticleIds");
        // 변환 가능한지 확인하고 맞다면 타입변환
        if(sessionItem instanceof ArrayList<?>){
            List<Long> viewedArticleIds = (ArrayList<Long>)sessionItem;

            // 방문게시글 목록에 현재 게시글 id가 포함되는가?
            if(viewedArticleIds.contains(article.getId()) == false ){
                viewedArticleIds.add(id); // 세션에 방문한 게시글 담아서 보내주기
                httpSession.setAttribute("viewedArticleIds" , viewedArticleIds);
                article.updateView(); // 조회수 증가
                return article;
            }
            // 포함되어 있다면 그냥 게시글 돌려주기
            else {
                return article;
            }

        }
        // 아니라면 일단 증가로직 없이 게시글 돌려준다.
        else {
            return article;
        }
    }







}

