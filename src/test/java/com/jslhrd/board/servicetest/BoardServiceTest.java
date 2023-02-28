package com.jslhrd.board.servicetest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jslhrd.board.service.BoardService;

@SpringBootTest
public class BoardServiceTest {
	private static final Logger log = 
			LoggerFactory.getLogger(BoardServiceTest.class);
	
	@Autowired
	private BoardService service;
	
	@Test
	public void boardCountTest() {
		log.info("Service Total :" + service.boardCount());
	}
}
