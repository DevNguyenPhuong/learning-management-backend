package com.learning.learning.task;

import com.learning.learning.DTO.request.CreateTaskRequest;
import com.learning.learning.DTO.request.UpdateTaskRequest;
import com.learning.learning.DTO.response.ApiResponse;
import com.learning.learning.DTO.response.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public ApiResponse<TaskResponse> createTask(@RequestBody CreateTaskRequest request) {
        ApiResponse<TaskResponse> apiResponse = new ApiResponse<>();
        apiResponse.setData(taskService.createTask(request));
        return apiResponse;
    }

    @PutMapping("/{taskId}")
    public ApiResponse<TaskResponse> updateTask(@RequestBody UpdateTaskRequest request, @PathVariable String taskId) {
        ApiResponse<TaskResponse> apiResponse = new ApiResponse<>();
        apiResponse.setData(taskService.updateTask(taskId, request));
        return apiResponse;
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable String taskId) {
        taskService.deleteTask(taskId);
    }
}
