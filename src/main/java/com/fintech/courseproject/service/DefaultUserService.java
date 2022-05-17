package com.fintech.courseproject.service;

import com.fintech.courseproject.converter.UserConverter;
import com.fintech.courseproject.dto.UserDto;
import com.fintech.courseproject.entity.User;
import com.fintech.courseproject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDto saveUser(UserDto userDTO) {
        validateUserDTO(userDTO);
        User savedUser = userRepository.save(userConverter.fromUserDtoToUser(userDTO));
        return userConverter.fromUserToUserDto(savedUser);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }

    private void validateUserDTO(UserDto userDTO) {
        if (userDTO == null) log.error("Object user is null!");
        if (userDTO.getPhoneNumber() == null ||
            userDTO.getPhoneNumber().equals("")) log.error("Phone number is empty!");
        boolean isUserExists = userRepository.findAll()
                .stream().noneMatch(u -> u.getPhoneNumber().equals(userDTO.getPhoneNumber()));
        if (isUserExists) log.error("This user already exists!");
    }
}
