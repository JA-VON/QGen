package com.qgen.sys;

/**
 * Created by javon on 06/03/2016.
 */
public class QGenException extends Throwable{

    private String message;

    public QGenException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
