package com.learning.learning.schedule;

import com.learning.learning.DTO.request.CreateScheduleRequest;
import com.learning.learning.DTO.response.ScheduleResponse;
import com.learning.learning.DTO.response.TaskResponse;
import com.learning.learning.task.Task;
import com.learning.learning.task.TaskRepository;
import com.learning.learning.user.User;
import com.learning.learning.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public ScheduleResponse createSchedule(CreateScheduleRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow();
        var schedule = Schedule.builder()
                .user(user)
                .content(request.getContent())
                .priority(request.getPriority() != null ? request.getPriority() : null)
                .startAt(request.getStartAt() != null ? request.getStartAt() : null)
                .endAt(request.getEndAt() != null ? request.getEndAt() : null)
                .build();
        scheduleRepository.save(schedule);

        return ScheduleResponse.builder()
                .userId(user.getId())
                .content(request.getContent())
                .priority(request.getPriority() != null ? request.getPriority() : null)
                .startAt(request.getStartAt() != null ? request.getStartAt() : null)
                .endAt(request.getEndAt() != null ? request.getEndAt() : null)
                .build();
    }


    public List<TaskResponse> getTasks(String scheduleId) {
        return taskRepository.findAllBySchedule_Id(scheduleId)
                .stream()
                .map(this::convertToTaskResponse)
                .collect(Collectors.toList());
    }

    private TaskResponse convertToTaskResponse(Task task) {
        TaskResponse res = new TaskResponse();
        res.setId(task.getId());
        res.setTitle(task.getTitle());
        res.setCompleted(task.getCompleted());
        res.setCompletedAt(task.getCompletedAt());
        res.setStartAt(task.getStartAt());
        res.setDuration(task.getDuration());
        res.setStatus(task.getStatus());
        res.setScheduleId(task.getSchedule().getId());
        return res;
    }
}
