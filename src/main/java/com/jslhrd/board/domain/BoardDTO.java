package com.jslhrd.board.domain;

import lombok.Data;

@Data
public class BoardDTO {
	private int idx;
	private String pass;
	private String name;
	private String email;
	private String regdate;
	private String subject;
	private String contents;
	private int readcnt;
}
