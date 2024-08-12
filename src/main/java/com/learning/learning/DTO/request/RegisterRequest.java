package com.learning.learning.DTO.request;

import com.learning.learning.user.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
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
    @Size(min = 8, message = "INVALID_USERNAME")
    private  String username;
    @Size(min = 8, message = "INVALID_PASSWORD")
    private  String password;
    private  Integer age;
    private  String gender;
    private  String description;
    private  String major;
    private  String objective;
    @Email(message = "Not a valid email")
    private  String email;
    private  String experience;
    private Role role;
}
