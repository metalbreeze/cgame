package com.cgame.exception;

import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {

    public GeneralException(String message) {
        super(message);
    }
}
