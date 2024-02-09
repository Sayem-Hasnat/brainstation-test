package com.hasnat.bs23.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserEventConsumerDto {
    private String message;
    private UserDto userDto;
}
