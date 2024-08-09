package com.learning.learning.note;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateNoteRequest {
    private  String title;
    private  String content;
    private Boolean bookMarked;
}
