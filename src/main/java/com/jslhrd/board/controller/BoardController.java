package com.jslhrd.board.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jslhrd.board.domain.BoardDTO;
import com.jslhrd.board.domain.PageDTO;
import com.jslhrd.board.service.BoardService;

@Controller
@RequestMapping("Board")
public class BoardController {
	private static final Logger log = 
			LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	@GetMapping("board_list")
	public void BoardList(Model model) {
		log.info("boardList()......");
		model.addAttribute("totcount" , service.boardCount());
		model.addAttribute("list", service.boardList());
	}
	
//	@GetMapping("board_list")
//	public void BoardList(Model model, @PageableDefault(page=0,size=10,sort="idx",direction = Sort.Direction.DESC) Pageable pageaable) {
//		
//	}
	//글 찾기
	@PostMapping("board_list")
	public void boardListSearch(PageDTO dto, Model model) {
		model.addAttribute("totcount", service.boardCountSearch(dto));
		model.addAttribute("list", service.boardListSearch(dto));
		log.info("Controller boardListSearch()....."+service.boardListSearch(dto).size());
	}
	//글 등록
	@GetMapping("board_write")
	public void GOBoardWrite() {
		log.info("GOboard_write()......");
	}
	@PostMapping("board_write")
	public String BoardWrite(BoardDTO dto , RedirectAttributes rtts) {
		log.info("board_write()......");
		int row = service.boardWrite(dto);
		rtts.addFlashAttribute("row", row);
		return "redirect:board_write_pro";
	}
	@GetMapping("board_write_pro")
	public void BoardWritePro() {
		
	}
	//쿠키를 서비스에서 처리
	@GetMapping("board_hits")
	public String boardHist(@RequestParam("idx") int idx,HttpServletRequest request,
			HttpServletResponse response) {
		service.boardHits(idx, request, response);
		
		return "redirect:board_view?idx="+idx;
	}
	
	@GetMapping("board_view")
	public void boardView(@RequestParam("idx") int idx, Model model) {
		log.info("board_View......");
		//idx에 해당하는 글 검색
		BoardDTO board = service.boardSelect(idx);
		board.setContents(board.getContents().replace("\n", "<br>"));
		model.addAttribute("board", board);
	}
	//수정폼으로
	@GetMapping("board_modify")
	public void GOBoardModify(@RequestParam("idx")int idx, Model model) {
		log.info("GOBoardModify......");
		model.addAttribute("board", service.boardSelect(idx));
	}
	//수정받음
	@PostMapping("board_modify")
	public String BoardModify(BoardDTO dto, RedirectAttributes rtts) {
		
		int row = service.boardModify(dto);
		log.info("BoardModify...... ");
		rtts.addFlashAttribute("row", row);
		rtts.addFlashAttribute("idx",dto.getIdx());
		return "redirect:board_modify_pro";
	}
	@GetMapping("board_modify_pro")
	public void BoardModifyPro() {
		
	}
	
	//삭제팝업창
	@GetMapping("board_delete")
	public void GOBoarddelete(@RequestParam("idx")int idx, Model model) {
		log.info("GOBoarddelete...... ");
		model.addAttribute("board", service.boardSelect(idx));
	}
	
	//삭제하기
	@PostMapping("board_delete")
	public String BoardDelete(BoardDTO dto , RedirectAttributes rtts) {
		log.info("Boarddelete...... ");
		int row = service.boardDelete(dto);
		rtts.addFlashAttribute("row", row);
		return "redirect:board_delete_pro";
	}
	@GetMapping("board_delete_pro")
	public void BoardDeletePro() {
		
	}
	
}
