package com.fintech.courseproject.exceptions;

import lombok.Getter;

@Getter
public class ParcelWasOverdueException extends RuntimeException {

    private final String status;

    public ParcelWasOverdueException(String status) {
       this.status = status;
    }
}
