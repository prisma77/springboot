package com.multi.springboot.service;



import com.multi.springboot.model.Board;

import java.util.List;

public interface BoardService {
    List<Board> getAllBoards();
    Board getBoardById(int id);
    void insertBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(int id);
    void incrementViews(int id);    int count(String q, String type);
    List<Board> find(String q, String type, int offset, int limit);
}
