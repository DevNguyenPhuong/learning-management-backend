package com.learning.learning.auth;

import com.learning.learning.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private  String full_name;
    private  String username;
    private  String password;
    private  String age;
    private  String gender;
    private  String description;
    private  String major;
    private  String objective;
    private  String email;
    private  String experience;
    private Role role;
}
