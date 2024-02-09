package com.hasnat.bs23.controller;

import com.hasnat.bs23.constant.ApplicationConstant;
import com.hasnat.bs23.dto.UserDto;
import com.hasnat.bs23.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserDto userDto) {
        if (userService.getUserByUsername(userDto.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ApplicationConstant.USERNAME_ALREADY_EXIST);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userDto));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        UserDto userDto = userService.getUser(id);
        return userDto == null
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.status(HttpStatus.FOUND).body(userDto);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllUser() {
        List<UserDto> userDtoList = userService.getAllUser();
        return userDtoList.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.status(HttpStatus.OK).body(userDtoList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody UserDto dto,
                                    @PathVariable Long id) {
        UserDto userDto = userService.getUser(dto.getId());
        if (userDto == null || !Objects.equals(userDto.getId(), id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(userDto));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        UserDto userDto = userService.getUser(id);
        if (userDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            userService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }


}
