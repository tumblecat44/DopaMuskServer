package com.leegeonhee.myum.user.controller;

import com.leegeonhee.myum.user.entity.Board;
import com.leegeonhee.myum.user.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @PostMapping("/write")
    public Board insertBoard(@RequestBody Board content) { return boardService.insertBoard(content);}

    @GetMapping("")
    public List<Board> getAllBoard() { return boardService.getAllBoardLatest();}

    @DeleteMapping("/clear")
    public String deleteAll(){boardService.allBoardDelete();
    return "삭제완료";}
}
