package com.spring.taskmanagement.dao.request;

import com.spring.taskmanagement.enums.TaskPointEnum;
import com.spring.taskmanagement.enums.TaskPriorityEnum;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskRequest {
    private Long userId;
    private TaskPointEnum point;
    private TaskPriorityEnum priority;

    @NotBlank(message = "description in required")
    @Min(value = 3, message = "description should be at least 3 characters long")
    @Max(value = 100, message = "description should not be more than 150 characters long")
    private String description;
}
