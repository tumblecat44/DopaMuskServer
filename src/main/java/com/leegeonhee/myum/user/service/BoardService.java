package com.leegeonhee.myum.user.service;


import com.leegeonhee.myum.user.entity.Board;
import com.leegeonhee.myum.user.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board insertBoard(Board content){
        return boardRepository.save(content);
    }

    public List<Board> getAllBoard(){return boardRepository.findAll();}
    public List<Board> getAllBoardLatest(){
        Sort sort = Sort.by(Sort.Order.by("id")).reverse();
        return boardRepository.findAll(sort);}

    public Optional<Board> getBoardById(Long id){return boardRepository.findById(id);}

    public void allBoardDelete(){boardRepository.deleteAll();}

    public void likeUp(Long id){
        Board board = boardRepository.findById(id).orElseThrow(() -> new NullPointerException("no id board "));
        board.setLikes(board.getLikes() + 1);
        boardRepository.save(board);
    }
    public void likeDown(Long id){
        Board board = boardRepository.findById(id).orElseThrow(() -> new NullPointerException("no id board "));
        board.setLikes(board.getLikes() - 1);
        boardRepository.save(board);
    }
}
