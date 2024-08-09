package com.learning.learning.note;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;
    @GetMapping("/{noteId}")
    public ResponseEntity<Note> getNote(@PathVariable String noteId) {
        return ResponseEntity.ok(noteService.getNoteById(noteId));
    }
}
