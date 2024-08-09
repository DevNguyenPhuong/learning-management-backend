package com.learning.learning.note;

import com.learning.learning.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private Boolean bookmarked;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}