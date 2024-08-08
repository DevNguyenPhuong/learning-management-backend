package com.learning.learning.user;

import com.learning.learning.note.Note;
import com.learning.learning.note.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final NoteRepository noteRepository;
    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("helelo");
    }

    @GetMapping("/{userId}/notes")
    public ResponseEntity<List<Note>> getNotesByUserId(@PathVariable String userId) {
        // Assuming you have a UserService that can retrieve the User object
        return ResponseEntity.ok(noteRepository.findAllByUser_Id(userId));
    }
}
