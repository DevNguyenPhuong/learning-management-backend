package com.learning.learning.DTO.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskRequest {
    private String id;
    private String title;
    private Boolean completed;
    private String scheduleId;
}
