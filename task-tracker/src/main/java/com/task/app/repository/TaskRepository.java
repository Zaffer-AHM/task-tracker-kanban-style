package com.task.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.task.app.entity.Task;
import com.task.app.entity.BoardColumn;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByColumn(BoardColumn column);
}