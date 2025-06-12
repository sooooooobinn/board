package com.example.board.controller;

import com.example.board.entity.Board;
import com.example.board.service.BoardService;
import com.example.board.repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    // 글 목록 조회
    @GetMapping("/list")
    public List<Board> getBoardList() {
        return boardService.getBoardList();
    }

    // 글 하나 조회
    @GetMapping("/{id}")
    public Board getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    // 글 작성
    @PostMapping("/write")
    public Board writeBoard(@RequestBody Board board) {
        return boardService.saveBoard(board);
    }

    // 글 수정
    @PutMapping("/update/{id}")
    public Board updateBoard(@PathVariable Long id, @RequestBody Board board) {
        Optional<Board> existing = boardRepository.findById(id);
        if (existing.isEmpty()) {
            throw new RuntimeException("해당 ID의 게시글이 존재하지 않습니다.");
        }
        return boardService.updateBoard(id, board);
    }

    // 글 삭제
    @DeleteMapping("/delete/{id}")
    public String deleteBoard(@PathVariable Long id) {
        boardService.deletBoard(id);
        return "삭제 완료!";
    }
}

