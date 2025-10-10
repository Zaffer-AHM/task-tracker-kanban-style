package com.task.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.task.app.entity.BoardColumn;
import com.task.app.entity.Board;
import java.util.List;

public interface ColumnRepository extends JpaRepository<BoardColumn, Long> {
    List<BoardColumn> findByBoard(Board board);
}