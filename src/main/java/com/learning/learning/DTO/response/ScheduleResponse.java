package com.learning.learning.DTO.response;

import com.learning.learning.schedule.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponse {
    private String id;
    private String day;
    private String content;
    private Priority priority;
    private Instant startAt;
    private Instant endAt;
    private String userId;
}
