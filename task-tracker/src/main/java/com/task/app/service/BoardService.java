package com.task.app.service;

import com.task.app.entity.Board;
import com.task.app.entity.User;
import java.util.List;
import java.util.Optional;

public interface BoardService {
    List<Board> getBoardsByUser(User user);
    Optional<Board> getBoardById(Long id);
    Board createBoard(Board board);
    void deleteBoard(Long id);
}
