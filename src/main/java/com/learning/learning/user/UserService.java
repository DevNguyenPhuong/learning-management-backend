package com.learning.learning.user;

import com.learning.learning.DTO.response.NoteResponse;
import com.learning.learning.note.Note;
import com.learning.learning.note.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final NoteRepository noteRepository;

    public List<NoteResponse> getUserNotes(String userId) {
        return noteRepository.findAllByUser_Id(userId)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private NoteResponse convertToResponse(Note note) {
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
}
