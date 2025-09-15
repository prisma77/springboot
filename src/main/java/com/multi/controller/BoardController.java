package com.multi.controller;

import com.multi.model.Board;
import com.multi.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("boardList", boardService.getAllBoards());
        return "list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        boardService.incrementViews(id);
        model.addAttribute("board", boardService.getBoardById(id));
        return "view";
    }

    @GetMapping("/write")
    public String writeForm() {
        return "write";
    }

    @PostMapping("/write")
    public String write(Board board) {
        boardService.insertBoard(board);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.getBoardById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Board board) {
        boardService.updateBoard(board);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        boardService.deleteBoard(id);
        return "redirect:/list";
    }
}