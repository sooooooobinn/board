package com.example.board.repository;

import java.util.List;
import java.util.ArrayList;
import com.example.board.entity.Board;

public class test {
    private List<Board> boards = new ArrayList<>();
    private Long nextId = 1L;

    public void save(Board board) {
        board.setId(nextId++);
        boards.add(board);
    }

    public List<Board> findAll() {
        return boards;
    }

    public Board findBuId(Long id) {
        for (Board board : boards) {
            if(board.getId().equals(id)) {
                return board;
            }
        }
        return null;
    }
    public void deleteById(Long id) {
        boards.removeIf(board -> board.getId().equals(id));
    }
}


