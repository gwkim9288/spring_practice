package com.gwkim.posting.service;

import com.gwkim.posting.domain.BoardVO;

public interface BoardService {

	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
}
