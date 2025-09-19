package com.multi.springboot.controller;

import com.multi.springboot.model.Comment;
import com.multi.springboot.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @PostMapping
    public String addComment(@RequestParam String content) {
        commentService.addComment(content);
        System.out.println(content);
        return "Comment added successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return "Comment deleted successfully";
    }

    @PutMapping("/{id}")
    public String updateComment(@PathVariable Long id, @RequestParam String content) {
        commentService.updateComment(id, content);
        return "Comment updated successfully";
    }
}