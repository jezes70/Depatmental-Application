package com.cyngofokgloba.Springbootdemo.error;

public class DepartmentNotfoundException extends Exception {
    public DepartmentNotfoundException() {
        super();
    }

    public DepartmentNotfoundException(String message) {
        super(message);
    }

    public DepartmentNotfoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotfoundException(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotfoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
