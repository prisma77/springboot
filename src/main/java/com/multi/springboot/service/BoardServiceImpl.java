package com.multi.springboot.service;

import com.multi.springboot.mapper.BoardMapper;
import com.multi.springboot.model.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper mapper;

    public BoardServiceImpl(BoardMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Board> getAllBoards() {
        return mapper.getAllBoards();
    }

    @Override
    public Board getBoardById(int id) {
        return mapper.getBoardById(id);
    }

    @Override
    public void insertBoard(Board board) {
        mapper.insertBoard(board);
    }

    @Override
    public void updateBoard(Board board) {
        mapper.updateBoard(board);
    }

    @Override
    public void deleteBoard(int id) {
        mapper.deleteBoard(id);
    }

    @Override
    public void incrementViews(int id) {
        mapper.incrementViews(id);
    }

    // 🔽 추가
    @Override
    public int count(String q, String type) {
        return mapper.count(q, type);
    }

    @Override
    public List<Board> find(String q, String type, int offset, int limit) {
        return mapper.find(q, type, offset, limit);
    }
}
