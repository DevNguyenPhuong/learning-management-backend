package com.learning.learning.note;

import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, String> {

    @Nonnull
    Optional<Note> findById(@Nonnull String id);
    @Query("SELECT n FROM Note n WHERE n.user.id = :userId")
    List<Note> findAllByUser_Id(@Param("userId") String userId);
    void deleteById(@Nonnull String id);
}
