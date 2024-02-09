package com.hasnat.bs23.service;

import com.hasnat.bs23.dto.UserDto;
import com.hasnat.bs23.entity.User;
import com.hasnat.bs23.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    protected static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public UserDto save(UserDto dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        user = userRepo.save(user);
        BeanUtils.copyProperties(user, dto);

        return dto;
    }

    public UserDto getUser(Long id) {
        log.info("Get User Data From Database");
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isEmpty()) {
            return null;
        } else {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(optionalUser.get(), dto);
            return dto;
        }
    }

    public boolean getUserByUsername(String username) {
        return userRepo.existsByUsername(username);
    }

    public List<UserDto> getAllUser() {
        log.info("Get User Data From Database");
        List<User> userList = userRepo.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        userList.forEach(user -> {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(user, dto);
            userDtoList.add(dto);
        });
        return userDtoList;
    }

    public UserDto update(UserDto dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        user = userRepo.save(user);
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    public void delete(Long id) {
        userRepo.deleteById(id);
    }

}
