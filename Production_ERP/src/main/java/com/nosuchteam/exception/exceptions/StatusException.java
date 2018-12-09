package com.nosuchteam.exception.exceptions;

/**
 * @Author: Evan
 * @Date: 2018/12/8 11:19
 * @Description:
 */
public class StatusException extends Exception {
    public StatusException() {
        super();
    }

    public StatusException(String message) {
        super(message);
    }

    public StatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public StatusException(Throwable cause) {
        super(cause);
    }

    protected StatusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
