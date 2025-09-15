package com.multi.springboot.mapper;

import com.multi.springboot.model.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getAllBoards();
    Board getBoardById(int id);
    void insertBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(int id);
    void incrementViews(int id);

    int count(@Param("q") String q, @Param("type") String type);

    List<Board> find(@Param("q") String q,
                     @Param("type") String type,
                     @Param("offset") int offset,
                     @Param("limit") int limit);
}

