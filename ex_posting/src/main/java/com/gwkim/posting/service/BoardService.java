package com.gwkim.posting.service;

import java.util.List;

import com.gwkim.posting.domain.BoardVO;
import com.gwkim.posting.domain.Criteria;

public interface BoardService {

	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public List<BoardVO> getList();

	public boolean remove(Long bno);

	public boolean modify(BoardVO board);
	
	public List<BoardVO> getList(Criteria cri);
}
