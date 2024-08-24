package com.learning.learning.task;

import com.learning.learning.DTO.request.CreateTaskRequest;
import com.learning.learning.DTO.request.UpdateTaskRequest;
import com.learning.learning.DTO.response.TaskResponse;
import com.learning.learning.schedule.Schedule;
import com.learning.learning.schedule.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final ScheduleRepository scheduleRepository;
    public TaskResponse createTask(CreateTaskRequest request) {
        Schedule schedule = scheduleRepository.findById(request.getScheduleId()).orElseThrow();

        var task = Task.builder()
                .schedule(schedule)
                .title(request.getTitle())
                .completed(request.getCompleted())
                .build();
        taskRepository.save(task);

        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .completed(task.getCompleted())
                .build();
    }

    public void deleteTask(String taskId) {
        taskRepository.deleteById(taskId);
    }

    public TaskResponse updateTask(String taskId, UpdateTaskRequest newTask) {
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));

        existingTask.setTitle(newTask.getTitle());
        existingTask.setCompleted(newTask.getCompleted());
        taskRepository.save(existingTask);

        return  TaskResponse.builder()
                .id(newTask.getId())
                .title(newTask.getTitle())
                .completed(newTask.getCompleted())
                .build();
    }
}
