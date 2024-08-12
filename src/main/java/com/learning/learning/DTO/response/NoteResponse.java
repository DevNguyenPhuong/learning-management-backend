package com.learning.learning.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoteResponse {
    private String id;
    private String title;
    private Boolean bookmarked;
    private String content;
    private String date;
    private String time;
    private String userId;

}
