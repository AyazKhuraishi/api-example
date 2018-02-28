package com.github.rodolfoba.apiexample;

public enum ErrorCode {

    INTERNAL_SERVER_ERROR("Internal server error"),
    NOT_FOUND("Not found"),
    BAD_REQUEST("Bad request")
    ;
    
    private final String description;
    
    private ErrorCode(final String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
}
