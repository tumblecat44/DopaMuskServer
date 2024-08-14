package com.leegeonhee.myum.user.controller;

import com.leegeonhee.myum.user.entity.Board;
import com.leegeonhee.myum.user.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @PostMapping("/write")
    public Board insertBoard(@RequestBody Board content) { return boardService.insertBoard(content);}


    @GetMapping("/{id}")
    public Optional<Board> getBoard(@PathVariable Long id) {return boardService.getBoardById(id);}



    @GetMapping("")
    public List<Board> getAllBoard() { return boardService.getAllBoardLatest();}

    @DeleteMapping("/clear")
    public String deleteAll(){boardService.allBoardDelete();
    return "삭제완료";}

    @PatchMapping("/up/{id}")
    public ResponseEntity<Void> upLikes(@PathVariable Long id) {
        boardService.likeUp(id);
        return ResponseEntity.ok().build();  // 성공 응답 반환
    }
    @PatchMapping("/down/{id}")
    public ResponseEntity<Void> downLikes(@PathVariable Long id) {
        boardService.likeDown(id);
        return ResponseEntity.ok().build();  // 성공 응답 반환
    }
}
