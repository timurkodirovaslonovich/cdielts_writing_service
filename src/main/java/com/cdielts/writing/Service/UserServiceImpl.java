package com.cdielts.writing.service;


import com.cdielts.writing.Dto.UserRequestDto;
import com.cdielts.writing.Dto.UserResponseDto;
import com.cdielts.writing.entity.User;
import com.cdielts.writing.service.UserService;
import com.cdielts.writing.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto getUserById(UUID id) {
        return userRepository.findById(id).map(this::toDto).orElseThrow(() ->
            new NoSuchElementException("User with id " + id + " not found")
        );
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public UserResponseDto createUser(UserRequestDto request) {
        if (userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new RuntimeException("Phone number " + request.getPhoneNumber() + " already exists");
        } else {
            User user = new User(
                    request.getName(),
                    request.getPhoneNumber(),
                    request.getRole(),
                    request.getPassword()
            );
            userRepository.save(user);
            return toDto(user);
        }
    }


    @Override
    public UserResponseDto toDto(User user) {
        return new  UserResponseDto(
                user.getUuid(),
                user.getName(),
                user.getPhoneNumber(),
                user.getUserRole()
        );
    }
}
