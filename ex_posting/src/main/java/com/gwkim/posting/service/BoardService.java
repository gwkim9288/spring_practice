package com.gwkim.posting.service;

import java.util.List;

import com.gwkim.posting.domain.BoardVO;

public interface BoardService {

	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public List<BoardVO> getList();

	boolean remove(Long bno);

	boolean modify(BoardVO board);
}
