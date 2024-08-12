package com.learning.learning.note;

import com.learning.learning.DTO.request.CreateUpdateNoteRequest;
import com.learning.learning.DTO.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;
    @GetMapping("/{noteId}")
    public ApiResponse<Note> getNote(@PathVariable String noteId) {
        ApiResponse<Note> apiResponse = new ApiResponse<>();
        apiResponse.setData(noteService.getNoteById(noteId));
        return apiResponse;
    }

    @PostMapping
    public  ApiResponse<Note> createNote(@RequestBody CreateUpdateNoteRequest request) {
       ApiResponse<Note> apiResponse = new ApiResponse<>();
       apiResponse.setData(noteService.createNote(request));
        return apiResponse;
    }


    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable String noteId) {
        noteService.deleteNote(noteId);
    }

    @PutMapping("/{noteId}")
    public ApiResponse<Note> updateNote(@PathVariable String noteId, @RequestBody CreateUpdateNoteRequest request) {
        ApiResponse<Note> apiResponse = new ApiResponse<>();
        apiResponse.setData(noteService.updateNote(request, noteId));
        return apiResponse;
    }

}
