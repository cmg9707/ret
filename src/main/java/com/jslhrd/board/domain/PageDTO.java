package com.jslhrd.board.domain;

import lombok.Data;

@Data
public class PageDTO {
	// 검색용
	private String search;
	private String key;

	// 페이징
	private int startPage;
	private int endPage;
	private int nowpage;
}
