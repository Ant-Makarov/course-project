package com.fintech.courseproject.controller;

import com.fintech.courseproject.dto.UserDto;
import com.fintech.courseproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public UserDto saveUser(@RequestBody UserDto userDto) {
        log.info("Handling save user: " + userDto);
        return userService.saveUser(userDto);
    }


}
