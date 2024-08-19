package com.learning.learning.DTO.request;

import com.learning.learning.schedule.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateScheduleRequest {
    private String userId;
    private  String date;
    private  String content;
    private Priority priority;
}
