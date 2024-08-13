package com.leegeonhee.myum.user.service;


import com.leegeonhee.myum.user.entity.Board;
import com.leegeonhee.myum.user.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public void allBoardDelete(){boardRepository.deleteAll();}

    public void likeUp(Long id){
        boardRepository.findById(id);
    }
}
