package com.task.app.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "boards")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoardColumn> columns = new ArrayList<>();

    public List<Task> getAllTasks() {
        List<Task> allTasks = new ArrayList<>();
        for (BoardColumn column : columns) {
            allTasks.addAll(column.getTasks());
        }
        return allTasks;
    }
}
