package com.spring.websecurity.websecurity.Exception;


public class UserNotSubscribedException extends RuntimeException{
    public UserNotSubscribedException(String message)
    {
        super(message);
    }
}