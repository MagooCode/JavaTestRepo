package com.spring.taskmanagement.entity;

import com.spring.taskmanagement.enums.TaskPointEnum;
import com.spring.taskmanagement.enums.TaskPriorityEnum;
import com.spring.taskmanagement.enums.TaskStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    @SequenceGenerator(name = "task_id", sequenceName = "task_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id")
    @Id
    private Long id;
    private TaskPointEnum point;
    private TaskPriorityEnum taskPriority;
    private TaskStatusEnum taskStatus;
    private String description;
    private LocalDateTime deadline;

    @ManyToMany
    @JoinTable(name = "user_tasks",
        joinColumns = @JoinColumn(name="task_id"),
        inverseJoinColumns = @JoinColumn(name="user_id")
    )
    private List<User> users;
}