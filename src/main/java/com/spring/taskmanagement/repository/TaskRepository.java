package com.spring.taskmanagement.repository;

import com.spring.taskmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByDeadlineAfter(LocalDateTime deadline);
    List<Task> findAllByDeadlineEquals(LocalDateTime deadline);
    List<Task> findAllByDeadlineBetween(LocalDateTime startAt, LocalDateTime endAt);
}
