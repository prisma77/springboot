package com.multi.springboot.service;

import com.multi.springboot.mapper.CommentMapper;
import com.multi.springboot.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentMapper comments;


    public void addComment(String content) {
        Comment comment = new Comment();
        comment.setContent(content);

        comments.insertComment(comment);

    }

    public CommentService(CommentMapper comments) {
        super();
        this.comments = comments;
    }

    public void deleteComment(Long id) {
        comments.deleteComment(id);
    }

    public void updateComment(Long id, String content) {
        comments.updateComment(id,content);

    }

    public List<Comment> getAllComments() {
        // TODO Auto-generated method stub
        return comments.findAll();
    }
}
