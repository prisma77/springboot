package com.multi.service;

import com.multi.model.Board;
import java.util.List;

public interface BoardService {
    List<Board> getAllBoards();
    Board getBoardById(int id);
    void insertBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(int id);
    void incrementViews(int id);
}