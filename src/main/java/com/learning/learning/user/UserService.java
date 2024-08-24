package com.learning.learning.user;

import com.learning.learning.DTO.response.NoteResponse;
import com.learning.learning.DTO.response.ScheduleResponse;
import com.learning.learning.note.Note;
import com.learning.learning.note.NoteRepository;
import com.learning.learning.schedule.Schedule;
import com.learning.learning.schedule.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final NoteRepository noteRepository;
    private final ScheduleRepository scheduleRepository;

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
}
