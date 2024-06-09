package com.spring.taskmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @SequenceGenerator(name = "user_id", sequenceName = "user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
    @Id
    private Long id;
    private String username;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToMany(mappedBy="users")
    private List<Task> tasks;
}