package com.learning.learning.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateNoteRequest {
    private String userId;
    private  String title;
    private  String content;
    private Boolean bookmarked;
    private String date;
    private String time;
}
