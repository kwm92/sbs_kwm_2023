package com.kwm.exam.demo.service;

import org.springframework.stereotype.Service;

import com.kwm.exam.demo.repository.BoardRepository;
import com.kwm.exam.demo.vo.Board;

@Service
public class BoardService {
	private BoardRepository boardRepository;

	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	public Board getBoardById(int id) {
		return boardRepository.getBoardById(id);
	}
}
