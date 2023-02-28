package com.jslhrd.board.mappertest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jslhrd.board.mapper.BoardMapper;

@SpringBootTest
public class BoardMapperTest {
	private static final Logger log =
			LoggerFactory.getLogger(BoardMapperTest.class);
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void boardCountTest() {
		log.info("Total :"+ mapper.boardCount());
	}
}
