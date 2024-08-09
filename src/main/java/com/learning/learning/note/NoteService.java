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

    public Note getNoteById(String noteId) {
        return noteRepository.findById(noteId).orElse(null);
    }

    public void addNote(CreateNoteRequest request) {
        var note = Note.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .bookmarked(request.getBookMarked())
                .build();
    }
}
