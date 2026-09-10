package com.cdielts.writing.Dto;


import com.cdielts.writing.entity.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String role;
    private String username;
    private String password;
}
