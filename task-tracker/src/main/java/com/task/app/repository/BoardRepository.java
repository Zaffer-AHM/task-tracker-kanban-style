package com.task.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.task.app.entity.Board;
import com.task.app.entity.User;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByUser(User user);
}