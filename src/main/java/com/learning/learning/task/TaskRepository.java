package com.learning.learning.task;

import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, String> {

    @Nonnull
    Optional<Task> findById(@Nonnull String id);

    @Query("SELECT n FROM Task n WHERE n.schedule.id = :scheduleId")
    List<Task> findAllBySchedule_Id(@Param("scheduleId") String userId);

    void deleteById(@Nonnull String id);


}
