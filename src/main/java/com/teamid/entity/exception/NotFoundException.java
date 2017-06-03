package com.teamid.entity.exception;

/**
 * Created by Skye on 2017/6/3.
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
