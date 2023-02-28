package com.jslhrd.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.jslhrd.board.domain.BoardDTO;
import com.jslhrd.board.domain.PageDTO;

@Service
public interface BoardService {
	// 전체 게시글 수 카운트
	public int boardCount();

	// 전체 글 목록 출력
	public List<BoardDTO> boardList();

	// 글등록
	public int boardWrite(BoardDTO dto);

	// 글 조회수 증가
	public void boardHits(int idx, HttpServletRequest request, HttpServletResponse response);

	// 특정글 검색(view, modify)
	public BoardDTO boardSelect(int idx);

	// 수정
	public int boardModify(BoardDTO dto);

	// 삭제
	public int boardDelete(BoardDTO dto);

	// 전체글 목록(검색 o, 페이징 x)
	public List<BoardDTO> boardListSearch(PageDTO dto);

	// 검색조건을 이용한 카운트
	public int boardCountSearch(PageDTO dto);
}
