package com.example.board.service;

import com.example.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import com.example.board.repository.test;
import com.example.board.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service

public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    //1. 게시글 목록 조회
    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    //2. 특정 게시글 조회
    public Board getBoard(Long id) {
        Optional<Board> board = boardRepository.findById(id);
        return board.orElse(null);
    }

    //3. 게시글 작성
    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    public Board updateBoard(Long id, Board board) {
        Optional<Board> existing = boardRepository.findById(id);
        if (existing.isPresent()) {
            Board updated = existing.get();
            updated.setTitle(board.getTitle());
            updated.setContent(board.getContent());
            return boardRepository.save(updated);
        }
        return null;


    }
    public void deletBoard(Long id) {
        boardRepository.deleteById(id);
    }

}
