package com.learning.learning.DTO.response;


import com.learning.learning.task.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {
    private String id;
    private String title;
    private Boolean completed;
    private String scheduleId;
    private Status status;
    private Instant startAt;
    private Instant completedAt;
    private String duration;
}
