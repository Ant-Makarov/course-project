package com.fintech.courseproject.service;

import com.fintech.courseproject.entity.User;
import com.fintech.courseproject.exceptions.UserAlreadyExistsException;
import com.fintech.courseproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        List<User> userList = userRepository.findAll();
        User savedUser = null;
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
            throw new UserAlreadyExistsException(user.getPhoneNumber());
        }
        return savedUser;
    }
}
