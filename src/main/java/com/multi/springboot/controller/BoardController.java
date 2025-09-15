package com.multi.springboot.controller;

import com.multi.springboot.model.Board;
import com.multi.springboot.service.BoardService;
import com.multi.springboot.support.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 목록 + 검색 + 페이징
    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "1")  int page,
                       @RequestParam(defaultValue = "10") int size,
                       @RequestParam(required = false)    String q,
                       @RequestParam(defaultValue = "titleOrContent") String type,
                       Model model) {

        int total = boardService.count(q, type);
        Pagination pagination = new Pagination(page, size, total, 5); // 블록 5개

        List<Board> boards = boardService.find(q, type, pagination.getOffset(),
                pagination.getSize());
        model.addAttribute("boardList", boards);
        model.addAttribute("pagination", pagination);
        model.addAttribute("q", q == null ? "" : q);
        model.addAttribute("type", type);

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
