package com.learning.learning.auth;


import com.learning.learning.config.JwtService;
import com.learning.learning.user.Role;
import com.learning.learning.user.User;
import com.learning.learning.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private  final PasswordEncoder passwordEncoder;
    private  final JwtService jwtService;
    private  final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .full_name(request.getFull_name())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .age(request.getAge() != null ? request.getAge() : null)
                .gender(request.getGender() != null ? request.getGender() : "")
                .description(request.getDescription() != null ? request.getDescription() : "")
                .major(request.getMajor() != null ? request.getMajor() : "")
                .objective(request.getObjective() != null ? request.getObjective() : "")
                .email(request.getEmail() != null ? request.getEmail() : "")
                .experience(request.getExperience() != null ? request.getExperience() : "")
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .jwtToken(jwtToken)
                .full_name(request.getFull_name())
                .username(request.getUsername())
                .age(request.getAge() != null ? request.getAge() : null)
                .gender(request.getGender() != null ? request.getGender() : "")
                .description(request.getDescription() != null ? request.getDescription() : "")
                .major(request.getMajor() != null ? request.getMajor() : "")
                .objective(request.getObjective() != null ? request.getObjective() : "")
                .email(request.getEmail() != null ? request.getEmail() : "")
                .experience(request.getExperience() != null ? request.getExperience() : "")
                .role(Role.USER)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
       authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                       request.getUsername(),
                       request.getPassword()
               )
       );
       var user = repository.findByUsername(request.getUsername()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .jwtToken(jwtToken)
                .full_name(user.getFull_name())
                .username(request.getUsername())
                .age(user.getAge() != null ? user.getAge() : null)
                .gender(user.getGender() != null ? user.getGender() : "")
                .description(user.getDescription() != null ? user.getDescription() : "")
                .major(user.getMajor() != null ? user.getMajor() : "")
                .objective(user.getObjective() != null ? user.getObjective() : "")
                .email(user.getEmail() != null ? user.getEmail() : "")
                .experience(user.getExperience() != null ? user.getExperience() : "")
                .role(Role.USER)
                .build();
    }
}

