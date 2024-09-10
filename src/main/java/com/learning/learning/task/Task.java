package com.learning.learning.task;

import com.learning.learning.schedule.Schedule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Boolean completed;
    private String duration;
    private Instant startAt;
    private Instant completedAt;


    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(columnDefinition = "TEXT")
    private String title;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
}