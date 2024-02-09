package com.hasnat.bs23.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    @Column(name = "username", unique = true)
    private String username;
    private String email;
    private String name;
    private int age;
    private boolean isActive;
}
