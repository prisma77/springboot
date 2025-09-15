package com.multi.mapper;

import com.multi.model.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    // SELECT ... FROM board ORDER BY id DESC
    List<Board> getAllBoards();

    // SELECT ... FROM board WHERE id = #{id}
    Board getBoardById(int id);

    // INSERT INTO board (title, writer, content) VALUES (...)
    void insertBoard(Board board);

    // UPDATE board SET title=?, content=? WHERE id=?
    void updateBoard(Board board);

    // DELETE FROM board WHERE id=?
    void deleteBoard(int id);

    // UPDATE board SET views = views + 1 WHERE id=?
    void incrementViews(int id);

    // 검색 조건 포함 전체 개수: SELECT COUNT(*) FROM board WHERE ...
    int count(@Param("q") String q, @Param("type") String type);

    // 검색 + 페이징 목록: SELECT ... FROM board WHERE ... ORDER BY id DESC LIMIT offset, limit
    List<Board> find(@Param("q") String q,
                     @Param("type") String type,
                     @Param("offset") int offset,
                     @Param("limit") int limit);
}

