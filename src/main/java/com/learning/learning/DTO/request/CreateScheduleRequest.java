package com.learning.learning.DTO.request;
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
public class CreateScheduleRequest {
    private String content;
    private String userId;
    private Priority priority;
    private Instant startAt;
    private Instant endAt;
}
