package com.bookmark.service.exception;

public class NoBookMarkFoundException extends RuntimeException {

    public NoBookMarkFoundException(String message)
    {
        super(message);
    }
}
