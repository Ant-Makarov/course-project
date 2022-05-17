package com.fintech.courseproject.service;

import com.fintech.courseproject.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto saveUser(UserDto userDTO);
    List<UserDto> findAll();
}
