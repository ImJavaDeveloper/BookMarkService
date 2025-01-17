package com.bookmark.service.exception;

import lombok.Data;

@Data
public class ErrorMessage {

    private int status;
    private String error;

}
