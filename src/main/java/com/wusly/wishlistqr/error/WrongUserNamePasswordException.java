package com.wusly.wishlistqr.error;

public class WrongUserNamePasswordException extends RuntimeException{
    public WrongUserNamePasswordException(String message) {
        super(message);
    }
}
