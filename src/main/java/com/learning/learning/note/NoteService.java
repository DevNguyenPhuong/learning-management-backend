package com.learning.learning.note;

import com.learning.learning.DTO.request.CreateUpdateNoteRequest;
import com.learning.learning.user.User;
import com.learning.learning.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;


    public Note getNoteById(String noteId) {
        return noteRepository.findById(noteId).orElseThrow();
    }

    public  Note createNote(CreateUpdateNoteRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow();
        var note = Note.builder()
                .user(user)
                .title(request.getTitle())
                .content(request.getContent())
                .bookmarked(request.getBookmarked())
                .date(request.getDate())
                .time(request.getTime())
                .build();
        noteRepository.save(note);

        return note;
    }

    public void deleteNote(String noteId) {
        noteRepository.deleteById(noteId);
    }

    public Note updateNote(CreateUpdateNoteRequest newNote, String noteId) {
        Note existingNote = noteRepository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note not found with id: " + noteId));

        existingNote.setTitle(newNote.getTitle());
        existingNote.setContent(newNote.getContent());
        existingNote.setBookmarked(newNote.getBookmarked());
        existingNote.setDate(newNote.getDate());
        existingNote.setTime(newNote.getTime());
        return noteRepository.save(existingNote);
    }
}
