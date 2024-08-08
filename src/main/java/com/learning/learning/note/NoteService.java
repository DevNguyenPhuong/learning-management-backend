package com.learning.learning.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> getAllNotesByUserId(String userId) {
        return noteRepository.findAllByUser_Id(userId);
    }
}
