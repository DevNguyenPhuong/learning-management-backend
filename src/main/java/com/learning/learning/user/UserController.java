package com.learning.learning.user;

import com.learning.learning.DTO.request.UpdateUserRequest;
import com.learning.learning.DTO.response.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @GetMapping("/{userId}/notes")
    public ResponseEntity<List<NoteResponse>> getNotesByUserId(@PathVariable String userId) {

        return ResponseEntity.ok(userService.getUserNotes(userId));
    }

    @GetMapping("/{userId}/schedules")
    public ResponseEntity<List<ScheduleResponse>> getSchedulesByUserId(@PathVariable String userId) {

        return ResponseEntity.ok(userService.getUserSchedules(userId));
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
}
