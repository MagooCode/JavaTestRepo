package com.spring.taskmanagement.controller;

import com.spring.taskmanagement.entity.Task;
import com.spring.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping ("list")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping()
    public String create(Task task) {
        return taskService.createTask(task);
    }
}
