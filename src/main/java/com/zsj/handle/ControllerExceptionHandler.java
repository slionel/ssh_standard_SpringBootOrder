package com.zsj.handle;

import com.zsj.exception.DataValidationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zsj
 * @Date 2019.10.9
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e){

    }

    @ResponseBody
    @ExceptionHandler(DataValidationException.class)
    public void handleUserNotExistsException(DataValidationException e) {


    }
}
