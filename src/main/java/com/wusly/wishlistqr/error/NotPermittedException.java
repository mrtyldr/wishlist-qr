package com.wusly.wishlistqr.error;

public class NotPermittedException extends RuntimeException{
    public NotPermittedException() {
    }

    public NotPermittedException(String message) {
        super(message);
    }
}
