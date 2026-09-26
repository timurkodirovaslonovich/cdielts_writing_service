package com.cdielts.writing.controller;


import com.cdielts.writing.Dto.LoginRequest;
import com.cdielts.writing.Dto.RegisterRequest;
import com.cdielts.writing.entity.Role;
import com.cdielts.writing.entity.User;
import com.cdielts.writing.repository.UserRepository;
import com.cdielts.writing.security.JwtUtil;
import com.cdielts.writing.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    //constructor injection with lombok
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;



    //register
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        User user = new User();
        user.setName(request.getName());                        // ✅ add this — it's NOT NULL in DB
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUserRole(Role.valueOf(request.getRole()));                            // ✅ was Role.valueOf("ROLE_USER")
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");

    }


    //login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails user = customUserDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtUtil.generateToken(user);
        return ResponseEntity.ok(token);
    }
}
