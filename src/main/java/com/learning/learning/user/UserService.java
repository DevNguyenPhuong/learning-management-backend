package com.learning.learning.user;

import com.learning.learning.DTO.request.UpdateUserRequest;
import com.learning.learning.DTO.response.NoteResponse;
import com.learning.learning.DTO.response.ScheduleResponse;
import com.learning.learning.DTO.response.TaskResponse;
import com.learning.learning.DTO.response.UpdateUserResponse;
import com.learning.learning.note.Note;
import com.learning.learning.note.NoteRepository;
import com.learning.learning.schedule.Schedule;
import com.learning.learning.schedule.ScheduleRepository;
import com.learning.learning.schedule.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {
    private final NoteRepository noteRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    private final ScheduleService scheduleService;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UpdateUserResponse updateUser(UpdateUserRequest newUser, String userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Note not found with id: " + userId));

        existingUser.setFull_name(newUser.getFull_name());
        existingUser.setGender(newUser.getGender());
        existingUser.setEmail(newUser.getEmail());
        existingUser.setAge(newUser.getAge() != null ? newUser.getAge() : null);
        existingUser.setMajor(newUser.getMajor());
        existingUser.setExperience(newUser.getExperience());
        existingUser.setObjective(newUser.getObjective());
        existingUser.setDescription(newUser.getDescription());

        userRepository.save(existingUser);

        return UpdateUserResponse.builder()
                .id(newUser.getId())
                .full_name(newUser.getFull_name())
                .gender(newUser.getGender())
                .email(newUser.getEmail())
                .age(newUser.getAge())
                .major(newUser.getMajor())
                .experience(newUser.getExperience())
                .objective(newUser.getObjective())
                .description(newUser.getDescription())
                .build();
    }

    public List<NoteResponse> getUserNotes(String userId) {
        return noteRepository.findAllByUser_Id(userId)
                .stream()
                .map(this::convertToNoteResponse)
                .collect(Collectors.toList());
    }

    private NoteResponse convertToNoteResponse(Note note) {
        NoteResponse res = new NoteResponse();
        res.setId(note.getId());
        res.setTitle(note.getTitle());
        res.setBookmarked(note.getBookmarked());
        res.setContent(note.getContent());
        res.setDate(note.getDate());
        res.setTime(note.getTime());
        res.setUserId(note.getUser().getId());
        return res;
    }

    public List<ScheduleResponse> getUserSchedules(String userId) {
        return scheduleRepository.findAllByUser_Id(userId)
                .stream()
                .map(this::convertToScheduleResponse)
                .collect(Collectors.toList());
    }

    public List<TaskResponse> getUserSchedulesByDay(String userId, String day) {
        logger.info("Fetching schedules for userId: {} on day: {}", userId, day);
        Optional<Schedule> optionalSchedule = scheduleRepository.findByUserIdAndDay(userId, day);
        if (optionalSchedule.isEmpty()) {
            return Collections.emptyList();
        }
        Schedule schedule = optionalSchedule.get();
        return scheduleService.getTasks(schedule.getId());
    }

    private ScheduleResponse convertToScheduleResponse(Schedule schedule) {
        ScheduleResponse res = new ScheduleResponse();
        res.setId(schedule.getId());
        res.setContent(schedule.getContent());
        res.setPriority(schedule.getPriority());
        res.setStartAt(schedule.getStartAt());
        res.setEndAt(schedule.getEndAt());
        res.setUserId(schedule.getUser().getId());
        return res;
    }

    public ScheduleResponse getUpcomingEvent(String userId) {
        return scheduleRepository.findUpcomingEventForUser(userId)
                .map(this::convertToScheduleResponse)
                .orElse(new ScheduleResponse());
    }


}
