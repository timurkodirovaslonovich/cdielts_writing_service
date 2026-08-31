package com.cdielts.writing.service;

import com.cdielts.writing.Dto.UserRequestDto;
import com.cdielts.writing.Dto.UserResponseDto;
import com.cdielts.writing.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserResponseDto getUserById(UUID id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto createUser(UserRequestDto request);

    UserResponseDto toDto(User user);
}
