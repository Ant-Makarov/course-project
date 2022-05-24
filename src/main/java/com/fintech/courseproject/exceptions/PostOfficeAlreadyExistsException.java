package com.fintech.courseproject.exceptions;

import lombok.Getter;

@Getter
public class PostOfficeAlreadyExistsException extends RuntimeException {

    private final String description;

    public PostOfficeAlreadyExistsException(String description) {this.description = description;}
}
