package com.learning.learning.note;

import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, String> {

    @Nonnull
    Optional<Note> findById(@Nonnull String id);
    List<Note> findAllByUser_Id(String userId);
}
