package com.teamid.controller;

import com.teamid.entity.exception.ForbiddenException;
import com.teamid.entity.exception.NotAcceptableException;
import com.teamid.entity.exception.NotFoundException;
import com.teamid.entity.exception.UnanthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Skye on 2017/5/7.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnanthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public String unanthorized(UnanthorizedException e) {
        return e.toString();
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public String forbidden(ForbiddenException e) {
        return e.toString();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String notFound(NotFoundException e) {
        return e.toString();
    }

    @ExceptionHandler(NotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public String unanthorized(NotAcceptableException e) {
        return e.toString();
    }

}
