package com.pacemaker.usercenter.exception;

import com.pacemaker.usercenter.utils.ErrorCode;
import com.pacemaker.usercenter.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public Result businessExceptionHandler(BusinessException e)
    {
        log.error("businessException",e);
        return Result.error(ErrorCode.PAEAMS_ERROR);
    }
    @ExceptionHandler(RuntimeException.class)
    public Result runtimeExceptionHandler(RuntimeException e)
    {
        log.error("runtimeException",e);
        return Result.error(ErrorCode.PAEAMS_ERROR);
    }
}
