package com.jslhrd.board.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslhrd.board.domain.BoardDTO;
import com.jslhrd.board.domain.PageDTO;
import com.jslhrd.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper mapper;
	@Override
	public int boardCount() {
		return mapper.boardCount();
	}

	@Override
	public List<BoardDTO> boardList() {
		return mapper.boardList();
	}
	
	@Override
	public int boardWrite(BoardDTO dto) {
		return mapper.boardWrite(dto);
	}
	@Override
	public void boardHits(int idx, HttpServletRequest request, HttpServletResponse response) {
		boolean bool= false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int i=0 ; i<cookies.length; i++) { // 가지고 있는 쿠키 모두 조회
			info = cookies[i];
			if(info.getName().equals("boardCookie"+idx)) {//가지고 있는 쿠키 중에서 동일한것 찾기
				bool = true;
				break;
			}
		}
		String str="" + System.currentTimeMillis();
		if(!bool) {// 쿠키가 존재하지 않을 시
			info = new Cookie("boardCookie"+ idx, str);
			info.setMaxAge(60*5);//5분
			response.addCookie(info);
			mapper.boardHits(idx);
	}
		
	}
	@Override
	public BoardDTO boardSelect(int idx) {
		return mapper.boardSelect(idx);
	}
	
	@Override
	public int boardModify(BoardDTO dto) {
		return mapper.boardModify(dto);
	}
	@Override
	public int boardDelete(BoardDTO dto) {
		return mapper.boardDelete(dto);
	}
	@Override
	public List<BoardDTO> boardListSearch(PageDTO dto) {
		 return mapper.boardListSearch(dto);
	}
	@Override
	public int boardCountSearch(PageDTO dto) {
		return mapper.boardCountSearch(dto);
	}

}
