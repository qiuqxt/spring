package com.albert.excep;

// 定义 service 层可能会抛出的异常类 NotEnoughException
public class NotEnoughException extends RuntimeException {

    public NotEnoughException() {
        super();
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
