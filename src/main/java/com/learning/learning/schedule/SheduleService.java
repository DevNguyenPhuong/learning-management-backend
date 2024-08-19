package com.learning.learning.schedule;

import com.learning.learning.DTO.request.CreateScheduleRequest;
import com.learning.learning.user.User;
import com.learning.learning.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SheduleService {
    private final ScheduleReponsitory scheduleReponsitory;
    private final UserRepository userRepository;
    public Schedule createSchedule(CreateScheduleRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow();
        var schedule = Schedule.builder()
                .user(user)
                .date(request.getDate())
                .content(request.getContent())
                .priority(request.getPriority())
                .build();
        scheduleReponsitory.save(schedule);

        return schedule;
    }
}
