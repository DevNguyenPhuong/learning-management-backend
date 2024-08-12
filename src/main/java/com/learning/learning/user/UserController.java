package com.learning.learning.user;

import com.learning.learning.DTO.response.NoteResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("helelo");
    }

    @GetMapping("/{userId}/notes")
    public ResponseEntity<List<NoteResponse>> getNotesByUserId(@PathVariable String userId) {

        return ResponseEntity.ok(userService.getUserNotes(userId));
    }
}
