package com.learning.learning.schedule;


import com.learning.learning.DTO.request.CreateScheduleRequest;
import com.learning.learning.DTO.response.ApiResponse;
import com.learning.learning.DTO.response.ScheduleResponse;
import com.learning.learning.DTO.response.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public ApiResponse<ScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request) {
        ApiResponse<ScheduleResponse> apiResponse = new ApiResponse<>();
        apiResponse.setData(scheduleService.createSchedule(request));
        return apiResponse;
    }

    @GetMapping("/{scheduleId}/tasks")
    public ApiResponse<List<TaskResponse>> getTasks(@PathVariable String scheduleId) {
        ApiResponse<List<TaskResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setData(scheduleService.getTasks(scheduleId));
        return apiResponse;
    }


}
