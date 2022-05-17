package com.fintech.courseproject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder", toBuilder = true)
public class UserDto {

    private String fullName;
    private String email;
    private String phoneNumber;

}
