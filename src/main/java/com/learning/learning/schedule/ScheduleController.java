package com.learning.learning.schedule;

import com.learning.learning.DTO.request.CreateScheduleRequest;
import com.learning.learning.DTO.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final SheduleService scheduleService;
    @PostMapping
    public ApiResponse<Schedule> createSchedule(@RequestBody CreateScheduleRequest request) {
        ApiResponse<Schedule> apiResponse = new ApiResponse<>();
        apiResponse.setData(scheduleService.createSchedule(request));
        return apiResponse;
    }
}
