package com.gwkim.posting.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gwkim.posting.domain.BoardVO;
import com.gwkim.posting.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	static public Logger log = LoggerFactory.getLogger(BoardServiceTests.class.getName());
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	
	@Test
	public void testExist() {
		log.info(service.toString());
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("���� �ۼ��ϴ� ��:");
		board.setContent("���� �ۼ��ϴ� ����");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("������ �Խù��� ��ȣ: "+board.getBno());
	}
	
	@Test
	public void testGetList() {
		
		service.getList().forEach(board -> log.info(board.toString()));
	}
	
	@Test
	public void testGet() {
		log.info(service.get(1L).toString());
	}
	
	@Test
	public void testDelete() {
		log.info("remove result:"+service.remove(2L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board= service.get(1L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("������ �����մϴ�.");
		log.info("modify result:"+service.modify(board));
	}
}
