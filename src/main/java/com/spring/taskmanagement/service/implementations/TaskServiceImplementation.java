package com.spring.taskmanagement.service.implementations;

import com.spring.taskmanagement.entity.Task;
import com.spring.taskmanagement.repository.TaskRepository;
import com.spring.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImplementation implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImplementation(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getUserById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public String createTask(Task task) {
        taskRepository.save(task);
        return "Task successfully created!";
    }

    @Override
    public String updateTask(long id, Task taskToUpdate) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setPoint(existingTask.getPoint());
            existingTask.setDescription(existingTask.getDescription());
            return "User successfully updated";
        }
        return "";
    }

    @Override
    public String deleteTaskById(long id) {
        return "";
    }
}
