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


    Optional<Schedule> findByUserIdAndDay(String user_id, String day);



    @Query("SELECT s FROM Schedule s WHERE s.user.id = :userId AND s.content IS NOT NULL AND CAST(s.startAt AS TIMESTAMP) >= CURRENT_TIMESTAMP ORDER BY s.startAt ASC LIMIT 1")
    Optional<Schedule> findUpcomingEventForUser(@Param("userId") String userId);


}
