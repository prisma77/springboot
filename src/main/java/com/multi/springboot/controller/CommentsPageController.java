package com.multi.springboot.controller;

import com.multi.springboot.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommentsPageController {

    private final CommentService commentService;

    public CommentsPageController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public String showCommentsPage(Model model) {
        model.addAttribute("comments", commentService.getAllComments());
        return "comments"; // comments.jsp 렌더링
    }
}