package com.wusly.wishlistqr.error;

public class PhotoUploadUnSuccessfulException extends RuntimeException{
    public PhotoUploadUnSuccessfulException() {
    }

    public PhotoUploadUnSuccessfulException(String message) {
        super(message);
    }

    public PhotoUploadUnSuccessfulException(String message, Throwable cause) {
        super(message, cause);
    }
}
