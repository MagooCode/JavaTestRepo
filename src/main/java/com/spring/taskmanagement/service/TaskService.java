package com.spring.taskmanagement.service;

import com.spring.taskmanagement.entity.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTasks();
    public Task getUserById(long id);
    public String createTask(Task task);
    public String updateTask(long id, Task taskToUpdate);
    public String deleteTaskById(long id);
}
