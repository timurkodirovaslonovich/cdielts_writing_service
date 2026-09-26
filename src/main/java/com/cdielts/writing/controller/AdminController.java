package com.cdielts.writing.controller;


import com.cdielts.writing.Dto.UserResponseDto;
import com.cdielts.writing.Dto.WritingRequestDto;
import com.cdielts.writing.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserServiceImpl userService;



    @GetMapping("/users")
    @Operation(summary = "Getting all users")
    ResponseEntity<List<UserResponseDto>> getAllUsers() {
       List<UserResponseDto> users = userService.getAllUsers();
       return ResponseEntity.ok(users);
    }


    @GetMapping("/users/{id}")
    ResponseEntity<UserResponseDto> getUserById(@PathVariable UUID id) {
        UserResponseDto user = userService.getUserById(id);

        return ResponseEntity.ok(user);

    }


    //post mapping for adding writing test

    @PostMapping("/addWriting")
    ResponseEntity<String> addWriting(WritingRequestDto writing) {
    }


}
