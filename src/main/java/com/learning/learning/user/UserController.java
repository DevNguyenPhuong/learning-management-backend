package com.learning.learning.user;

import com.learning.learning.DTO.request.UpdateUserRequest;
import com.learning.learning.DTO.response.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @GetMapping("/{userId}/notes")
    public ApiResponse<List<NoteResponse>> getNotesByUserId(@PathVariable String userId) {
        ApiResponse<List<NoteResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setData(userService.getUserNotes(userId));
        return apiResponse;
    }

    @GetMapping("/{userId}/schedules")
    public ApiResponse<List<ScheduleResponse>> getSchedulesByUserId(@PathVariable String userId) {
        ApiResponse<List<ScheduleResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setData(userService.getUserSchedules(userId));
        return apiResponse;
    }

    @PutMapping("/{userId}")
    public  ApiResponse<UpdateUserResponse> updateUserInfo(@RequestBody UpdateUserRequest request, @PathVariable String userId) {
        ApiResponse<UpdateUserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setData(userService.updateUser(request, userId));
        return apiResponse;
    }

    @GetMapping("/{userId}/upComingEvent")
    public ApiResponse<ScheduleResponse> getUpComingEvent(@PathVariable String userId) {
        ApiResponse<ScheduleResponse> apiResponse = new ApiResponse<>();
        apiResponse.setData(userService.getUpcomingEvent(userId));
        return apiResponse;
    }

    @GetMapping("/{userId}/schedules/{day}")
    public ApiResponse<List<TaskResponse>> getTasksByDay(
            @PathVariable String userId,
            @PathVariable String day) {

        ApiResponse<List<TaskResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setData(userService.getUserSchedulesByDay(userId, day));
        return apiResponse;
    }

}
