package com.fintech.courseproject.exceptions;

import lombok.Getter;

@Getter
public class UserAlreadyExistsException extends RuntimeException{

    private final String phoneNumber;

    public UserAlreadyExistsException(String phoneNumber) {this.phoneNumber = phoneNumber;}
}
