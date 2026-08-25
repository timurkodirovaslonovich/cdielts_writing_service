package com.cdielts.writing.Dto;

import com.cdielts.writing.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class UserRequestDto {
    private UUID id;
    private String name;
    private String phoneNumber;
    private Role role;
    private String password;

    public UserRequestDto() {}
    public UserRequestDto(UUID id, String name, String phoneNumber, Role role, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.password = password;

    }
}
