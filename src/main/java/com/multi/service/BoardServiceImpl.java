package com.multi.service;

import com.multi.mapper.BoardMapper;
import com.multi.model.Board;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

//    public BoardServiceImpl(BoardMapper boardMapper) {
//        this.boardMapper = boardMapper;
//    }

    @Override
    public List<Board> getAllBoards() {
        return boardMapper.getAllBoards();
    }

    @Override
    public Board getBoardById(int id) {
        return boardMapper.getBoardById(id);
    }

    @Override
    public void insertBoard(Board board) {
        boardMapper.insertBoard(board);
    }

    @Override
    public void updateBoard(Board board) {
        boardMapper.updateBoard(board);
    }

    @Override
    public void deleteBoard(int id) {
        boardMapper.deleteBoard(id);
    }

    @Override
    public void incrementViews(int id) {
        boardMapper.incrementViews(id);
    }
}