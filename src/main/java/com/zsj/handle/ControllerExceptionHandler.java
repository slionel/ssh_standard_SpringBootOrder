package com.zsj.handle;

import com.zsj.exception.DataValidationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author zsj
 * @date 2019.10.9
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e){
        e.printStackTrace();
    }

    @ResponseBody
    @ExceptionHandler(DataValidationException.class)
    public void handleUserNotExistsException(DataValidationException e) {
        e.printStackTrace();
    }
}
