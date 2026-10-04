package com.cdielts.writing.controller;


import com.cdielts.writing.Dto.UserResponseDto;
import com.cdielts.writing.Dto.WritingRequestDto;
import com.cdielts.writing.entity.Writing;
import com.cdielts.writing.repository.WritingRepository;
import com.cdielts.writing.service.UserServiceImpl;
import com.cdielts.writing.service.WritingServiceImpl;
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
    private final WritingServiceImpl writingService;



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
    ResponseEntity<String> addWriting(@RequestBody WritingRequestDto writing) {
        WritingRequestDto newWriting = new WritingRequestDto(writing.getPassage1(), writing.getPassage2());



        //CHANGE THIS !!!
        //repository must not be used in controller layer so use service layer methods
        writingService.addWriting(newWriting);

        return ResponseEntity.ok("Writing is created");

    }


}
