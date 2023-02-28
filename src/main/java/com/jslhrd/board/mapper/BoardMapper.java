package com.jslhrd.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jslhrd.board.domain.BoardDTO;
import com.jslhrd.board.domain.PageDTO;

@Mapper
public interface BoardMapper {
	// 전체 게시글 수 카운트
	public int boardCount();

	// 전체 글 목록 출력
	public List<BoardDTO> boardList();

	// 글 조회수 증가
	public void boardHits(int idx);

	// 특정글 검색(view, modify)
	public BoardDTO boardSelect(int idx);

	// 글등록
	public int boardWrite(BoardDTO dto);

	// 수정
	public int boardModify(BoardDTO dto);

	// 삭제
	public int boardDelete(BoardDTO dto);

	// 전체글 목록(검색 o, 페이징 x)
	public List<BoardDTO> boardListSearch(PageDTO dto);

	// 검색조건을 이용한 카운트
	public int boardCountSearch(PageDTO dto);
}
