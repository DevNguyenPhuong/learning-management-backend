package com.learning.learning.note;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notes")
@RequiredArgsConstructor
public class NoteController {
    @GetMapping("/{noteId}")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("helelo");
    }
}
