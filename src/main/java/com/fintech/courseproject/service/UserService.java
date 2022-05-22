package com.fintech.courseproject.service;

import com.fintech.courseproject.entity.User;
import com.fintech.courseproject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        List<User> userList = userRepository.findAll();
        User savedUser;
        boolean isUserNotExists = userList.stream().noneMatch(u -> u.getPhoneNumber().equals(user.getPhoneNumber()));
        if (isUserNotExists) {
            savedUser = userRepository.save(User.builder()
                                                .fullName(user.getFullName())
                                                .email(user.getEmail())
                                                .phoneNumber(user.getPhoneNumber())
                                                .build());
            log.info("This user: " + user + "has been created successfully!");
        } else {
            log.error("This user: " + user + "already exists!");
        }
    }
}
