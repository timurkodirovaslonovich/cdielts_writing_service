package com.cdielts.writing.Dto;


import com.cdielts.writing.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserResponseDto {
    private UUID id;
    private String name;
    private String phoneNumber;
    private Role role;
    private List writingScore =  new ArrayList(10);

    public UserResponseDto() {}
    public UserResponseDto(UUID id, String name, String phoneNumber, Role role) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;

    }
}
