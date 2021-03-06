package com.gwkim.posting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwkim.posting.domain.BoardVO;
import com.gwkim.posting.domain.Criteria;
import com.gwkim.posting.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	//spring4.3 �̻󿡼� �ڵ�ó��
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		log.info("register........"+board);
		
		mapper.insertSelectKey(board);
	}

	
	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		log.info("get................"+bno);
		
		return mapper.read(bno);
	}


	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList.............");
		
		return mapper.getList();
	}
	
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify......"+board);
		
		return mapper.update(board) == 1;
	}
	
	@Override
	public boolean remove(Long bno) {
		log.info("remove....."+bno);
		
		return mapper.delete(bno) == 1;
	}
	
	@Override
	public List<BoardVO> getList(Criteria cri){
		return mapper.getListWithPaging(cri);
	}
	
}
