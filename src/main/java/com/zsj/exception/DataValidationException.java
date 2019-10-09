package com.zsj.exception;

/**
 * @author zsj
 */
public class DataValidationException extends RuntimeException {
    public DataValidationException(String msg){
        super(msg);
    }
}
