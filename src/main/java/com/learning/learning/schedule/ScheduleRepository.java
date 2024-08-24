package com.learning.learning.schedule;

import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {

    @Nonnull
    Optional<Schedule> findById(@Nonnull String id);

    @Query("SELECT n FROM Schedule n WHERE n.user.id = :userId")
    List<Schedule> findAllByUser_Id(@Param("userId") String userId);
}
