package com.task.app.service.impl;

import com.task.app.entity.Board;
import com.task.app.entity.User;
import com.task.app.repository.BoardRepository;
import com.task.app.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<Board> getBoardsByUser(User user) {
        return boardRepository.findByUser(user);
    }

    @Override
    public Optional<Board> getBoardById(Long id) {
        return boardRepository.findById(id);
    }

    @Override
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
