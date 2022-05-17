package com.fintech.courseproject.converter;

import com.fintech.courseproject.dto.UserDto;
import com.fintech.courseproject.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User fromUserDtoToUser(UserDto userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .fullName(userDto.getFullName())
                .phoneNumber(userDto.getPhoneNumber())
                .build();
    }

    public UserDto fromUserToUserDto(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .fullName(user.getFullName())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
