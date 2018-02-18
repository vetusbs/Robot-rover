package com.vetus.robotic.rover.controllers;

import org.springframework.http.HttpStatus;

public class RobotException extends RuntimeException {

    private HttpStatus statusCode;

    public RobotException(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public RobotException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public RobotException(String message, Throwable cause, HttpStatus statusCode) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
