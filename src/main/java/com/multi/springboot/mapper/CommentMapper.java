package com.multi.springboot.mapper;

import com.multi.springboot.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> findAll();
    void insertComment(Comment comment);
    void deleteComment(Long id);
    void updateComment(Long id,String content);
}