package com.nosuchteam.exception.exceptions;

/**
 * @Author: Evan
 * @Date: 2018/12/7 13:51
 * @Description:
 */
public class IllegalUserException extends Exception{
    public IllegalUserException() {
        super();
    }

    public IllegalUserException(String message) {
        super(message);
    }

    public IllegalUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalUserException(Throwable cause) {
        super(cause);
    }

    protected IllegalUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
