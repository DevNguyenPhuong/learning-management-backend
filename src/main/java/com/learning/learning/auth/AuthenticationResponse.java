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
public class AuthenticationResponse {
    private  String jwtToken;
    private  String full_name;
    private  String username;
    private  Integer age;
    private  String gender;
    private  String description;
    private  String major;
    private  String objective;
    private  String email;
    private  String experience;
    private Role role;
}
